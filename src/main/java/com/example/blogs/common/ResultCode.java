package com.example.blogs.common;

public enum ResultCode implements IErrorCode{
    //操作成功
    SUCCESS(200, "操作成功"),
    //操作失败
    FAILED(500, "操作失败"),
    //参数检验失败
    VALIDATE_FAILED(404, "参数检验失败"),
    //未登录或token已过期
    UNAUTHORIZED(401, "未登录或token已过期"),
    //没有相关权限
    FORBIDDEN(403, "没有相关权限");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
