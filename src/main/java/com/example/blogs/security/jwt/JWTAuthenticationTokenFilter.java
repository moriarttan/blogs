package com.example.blogs.security.jwt;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.example.blogs.constant.JWTConstant;
import com.example.blogs.security.entity.SelfUserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @create: 2021/12/9
 * @author: fb
 * @Description:
 */
@Slf4j
public class JWTAuthenticationTokenFilter extends BasicAuthenticationFilter {

    public JWTAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    
        String tokenHeader = request.getHeader(JWTConstant.tokenHeader);

        if(null != tokenHeader && tokenHeader.startsWith(JWTConstant.tokenPrefix)){
            try{
                // 截取JWT前缀
                String token = tokenHeader.replace(JWTConstant.tokenPrefix + StrUtil.SPACE, "");
                // 解析JWT
                Claims claims = Jwts.parser()
                        .setSigningKey(JWTConstant.secret)
                        .parseClaimsJws(token)
                        .getBody();
                // 获取用户id
                String userId = claims.getId();
                // 获取用户名
                String username = claims.getSubject();
                // 获取用户权限
                String authority = String.valueOf(claims.get("authorities"));
                
                if(StrUtil.isNotBlank(username) && StrUtil.isNotBlank(userId)){
                    // 获取角色权限
                    List<GrantedAuthority> authorities = new ArrayList<>();
                    if(StrUtil.isNotBlank(authority)){
                        List<Map<String, String>> authorityMap = JSON.parseObject(authority, List.class);
                        for (Map<String, String> role : authorityMap){
                            if(null != role){
                                authorities.add(new SimpleGrantedAuthority(role.get("authority")));
                            }
                        }
                    }

                    //组装参数
                    SelfUserEntity selfUserEntity = new SelfUserEntity();
                    selfUserEntity.setUsername(claims.getSubject());
                    selfUserEntity.setId(Long.parseLong(claims.getId()));
                    selfUserEntity.setAuthorities(authorities);

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(selfUserEntity, userId, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }catch (ExpiredJwtException e){
                log.info("Token过期");
            }catch (Exception e){
                log.info("Token无效");
            }
        }

        chain.doFilter(request, response);
    }
}
