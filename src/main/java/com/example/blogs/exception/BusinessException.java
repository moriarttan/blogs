package com.example.blogs.exception;

import com.example.blogs.common.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author fb
 * @version 1.0
 * @data 2021/9/14
 * @description 自定义异常
 */
@ApiModel(description = "自定义异常")
public class BusinessException extends RuntimeException{

    @ApiModelProperty(value = "自定义异常状态码")
    private int code = 500;

    @ApiModelProperty(value = "自定义异常信息")
    private String msg;


    public BusinessException(){
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.msg = message;
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
        this.msg = message;
    }

    public BusinessException(String message, int code, Throwable e) {
        super(message, e);
        this.msg = message;
        this.code = code;
    }
    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.msg = resultCode.getMessage();
        this.code = resultCode.getCode();
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
        this.msg = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
