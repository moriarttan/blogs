package com.example.blogs.security.utils;

import com.alibaba.fastjson.JSON;
import com.example.blogs.constant.JWTConstant;
import com.example.blogs.security.entity.SelfUserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @create: 2021/10/20
 * @author: fb
 * @Description: JWT工具类
 */
@Component
public class JWTUtil {
    
    /**
     * 私有化构造器
     */
    private JWTUtil(){}

    /**
     * 生成Token
     * @param selfUserEntity SpringSecurity用户的实体
     * @return
     */
    public static String createAccessToken(SelfUserEntity selfUserEntity){
        // 登陆成功生成JWT
        return Jwts.builder()
                // 用户ID
                .setId(String.valueOf(selfUserEntity.getId()))
                // 主体
                .setSubject(selfUserEntity.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("YQN")
                // 自定义属性 放入用户拥有权限
                .claim("authorities", JSON.toJSONString(selfUserEntity.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConstant.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS256, JWTConstant.secret)
                .compact();
    }
}
