package com.example.blogs.security.utils;

import com.example.blogs.security.entity.SelfUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @create: 2021/10/20
 * @author: fb
 * @Description: Security工具类
 */
@Slf4j
public class SecurityUtil {
    /**
     * 私有化构造器
     */
    private SecurityUtil(){}

    /**
     * 获取当前用户信息
     */
    public static SelfUserEntity getUserInfo(){
        try {
            return (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }

}
