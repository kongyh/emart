package com.fsd.emart.gateway.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsd.emart.gateway.config.DataFilterConfig;
import com.fsd.emart.gateway.util.JwtUtil;
import com.fsd.emart.gateway.util.PathUtil;
import com.fsd.emart.gateway.common.Result;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;

@Component
@Slf4j
public class LoginAddJwtPostFilter extends ZuulFilter {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    DataFilterConfig dataFilterConfig;


    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 2;
    }

   
    @Override
    public boolean shouldFilter() {
        
        RequestContext ctx = RequestContext.getCurrentContext();
        for (String pathPattern : dataFilterConfig.getUserLoginPath()) {
            if (PathUtil.isPathMatch(pathPattern, ctx.getRequest().getRequestURI())) {
                return true;
            }
        }
        return false;
    }

    
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            InputStream stream = ctx.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
            Result<HashMap<String, Object>> result = objectMapper.readValue(body, new TypeReference<Result<HashMap<String, Object>>>() {
            });
            //result.getCode() == 0 表示登录成功
            if (result.getCode() == 200) {
                HashMap<String, Object> jwtClaims = new HashMap<String, Object>() {{
                    put("username", result.getData().get("username"));
                }};
                Date expDate = DateTime.now().plusDays(7).toDate(); //过期时间 7 天
                String token = jwtUtil.createJWT(expDate, jwtClaims);
                //body json增加token
                result.getData().put("token", token);
                //序列化body json,设置到响应body中
                body = objectMapper.writeValueAsString(result);
                ctx.setResponseBody(body);

                //响应头设置token
                ctx.addZuulResponseHeader("token", token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
