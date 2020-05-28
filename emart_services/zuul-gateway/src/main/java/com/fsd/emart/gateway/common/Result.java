package com.fsd.emart.gateway.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code = 0;
    private String message = "ok";
    private T data;
}