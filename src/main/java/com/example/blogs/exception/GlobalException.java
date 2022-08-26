package com.example.blogs.exception;

import com.example.blogs.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * @author fb
 * @version 1.0
 * @data 2021/9/14
 * @description 异常参数处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    /**valid 参数校验异常处理*/
    @ExceptionHandler(value = {ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public Result<?> constraintValidatedExceptionHandler(HttpServletRequest request, Exception e, HandlerMethod method) {
        StringJoiner stringJoiner = new StringJoiner(";", "参数校验异常信息{ ", " }");
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            Optional.ofNullable(constraintViolationException.getConstraintViolations()).orElseGet(HashSet::new)
                    .forEach(v -> {
                        String message = v.getMessage();
                        PathImpl propertyPath = (PathImpl) v.getPropertyPath();
                        String s = propertyPath.getLeafNode().asString();
                        stringJoiner.add(s + ": " + message);
                    });
        }
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
            Optional.of(fieldErrors).orElseGet(ArrayList::new).forEach(v -> {
                String field = v.getField();
                String defaultMessage = v.getDefaultMessage();
                stringJoiner.add(field + ": " + defaultMessage);
            });
        }
        return Result.failed(stringJoiner.toString());
    }

    /**参数转换异常处理*/
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public Result<?> methodArgumentNotValidExceptionHandler(HttpMessageNotReadableException e) {
        String localizedMessage = e.getLocalizedMessage();
        String startMessage = "JSON parse error";
        if (localizedMessage.startsWith(startMessage)) {
            String throughReferenceChain = localizedMessage.substring(localizedMessage.lastIndexOf("through reference chain"));
            String field = throughReferenceChain.substring(throughReferenceChain.lastIndexOf("[\"") + 2, throughReferenceChain.lastIndexOf("\"]"));
            return Result.failed(field);
        }
        return Result.failed(localizedMessage);
    }

    /**自定义异常处理*/
    @ExceptionHandler(value = {BusinessException.class})
    public Result<?> businessExceptionHandler(HttpServletRequest request, BusinessException e, HandlerMethod method) {
        log.error("异常处理： businessException；\n【 远端请求地址：{}; 请求URI：{};" +
                        "\n 请求方法：{}； error message：{}】",
                request.getRemoteHost(), request.getRequestURI(),
                method.getMethod().getName(), e.getLocalizedMessage());
       return Result.failed(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public Result<?> illegalArgumentExceptionHandler(IllegalArgumentException e){
        return Result.failed(e.getMessage());
    }

}
