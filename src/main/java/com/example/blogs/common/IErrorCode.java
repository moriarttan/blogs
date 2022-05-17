package com.example.blogs.common;

/* 封装API的错误码
* */
public interface IErrorCode {
    /**
     * code
     * @return
     */
    Integer getCode();

    /**
     * message
     * @return
     */
    String getMessage();
}
