package com.fsd.emart.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsd.emart.gateway.common.Result;
import com.fsd.emart.gateway.config.DataFilterConfig;
import com.fsd.emart.gateway.util.JwtUtil;
import com.fsd.emart.gateway.util.PathUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.util.StreamUtils;
import java.io.InputStream;

@Component
@Slf4j
public class JwtAuthPreFilter extends ZuulFilter {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    DataFilterConfig dataFilterConfig;

    /**
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filterOrder：过滤的顺序 序号配置可参照 https://blog.csdn.net/u010963948/article/details/100146656
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 2;
    }

    /**
     * shouldFilter：逻辑是否要过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //路径与配置的相匹配，则执行过滤
        RequestContext ctx = RequestContext.getCurrentContext();
        for (String pathPattern : dataFilterConfig.getAuthPath()) {
            if (PathUtil.isPathMatch(pathPattern, ctx.getRequest().getRequestURI())) {
                return true;
            }
        }
        return false;
    }


    /**
     * 执行过滤器逻辑，验证token
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        InputStream in = (InputStream) ctx.get("requestEntity");
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("Authorization");
        Claims claims;
        try {
        	//header
            claims = jwtUtil.parseJWT(token);
            log.info("token : {} valid token", token);
            ctx.setSendZuulResponse(true);
            ctx.addZuulRequestHeader("username", claims.get("username").toString());
            //body
            if (in == null) {
				in = ctx.getRequest().getInputStream();
			}
            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            log.info("jwtauthprefilter-body:"+body);
            ctx.set("requestEntity", new ByteArrayInputStream(body.getBytes("UTF-8")));
            
        } catch (ExpiredJwtException expiredJwtEx) {
            log.error("token : {} expired", token);
            //不对请求进行路由
            ctx.setSendZuulResponse(false);
            responseError(ctx, -402, "token expired");
        } catch (Exception ex) {
            log.error("token : {} invalid token", token);
            //不对请求进行路由
            ctx.setSendZuulResponse(false);
            responseError(ctx, -401, "invalid token");
        }

        return null;
    }


    /**
     * 将异常信息响应给前端
     */
    private void responseError(RequestContext ctx, int code, String message) {
        HttpServletResponse response = ctx.getResponse();
        Result errResult = new Result();
        errResult.setCode(code);
        errResult.setMessage(message);
        ctx.setResponseBody(toJsonString(errResult));
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json;charset=utf-8");
    }

    private String toJsonString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("json序列化失败", e);
            return null;
        }
    }
}
