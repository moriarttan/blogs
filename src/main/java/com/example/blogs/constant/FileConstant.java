package com.example.blogs.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author fb
 * @version 1.0
 * @data 2021/9/23
 * @description 文件常量
 */
@Component
@ConfigurationProperties(prefix = "file")
public class FileConstant {
    /**
     * 上传路径
     */
    public static String targetUrl;

    /**
     * 上传大小
     */
    public static Long maxSize;
    
    /**
     * 返回前缀
     */
    public static String prefix;
    
    public void setTargetUrl(String targetUrl) {
        FileConstant.targetUrl = targetUrl;
    }
    
    public void setMaxSize(Long maxSize) {
        FileConstant.maxSize = maxSize;
    }
    
    public void setPrefix(String prefix) {
        FileConstant.prefix = prefix;
    }
}
