package com.fsd.emart.user.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code = 200;
    private String message = "ok";
    private T data;
}