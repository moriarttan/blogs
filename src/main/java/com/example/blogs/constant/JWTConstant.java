package com.example.blogs.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fb
 * @version 1.0
 * @data 2021/9/23
 * @description JWT常量
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConstant {
    /**
     * 密钥
     */
    public static String secret;

    /**
     * TokenKey
     */
    public static String tokenHeader;
    
    /**
     * Token前缀字符
     */
    public static String tokenPrefix;
    
    /**
     * 过期时间
     */
    public static Integer expiration;
    
    /**
     * 不需要认证的接口
     */
    public static List<String> antMatchers;
    
    public void setSecret(String secret) {
        JWTConstant.secret = secret;
    }
    
    public void setTokenHeader(String tokenHeader) {
        JWTConstant.tokenHeader = tokenHeader;
    }
    
    public void setTokenPrefix(String tokenPrefix) {
        JWTConstant.tokenPrefix = tokenPrefix;
    }
    
    public void setExpiration(Integer expiration) {
        JWTConstant.expiration = expiration;
    }
    
    public void setAntMatchers(List<String> antMatchers) {
        JWTConstant.antMatchers = antMatchers;
    }
}
