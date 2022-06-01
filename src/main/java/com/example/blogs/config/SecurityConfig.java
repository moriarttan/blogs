package com.example.blogs.config;

import cn.hutool.core.util.ArrayUtil;
import com.example.blogs.security.handler.UserAuthAccessDeniedHandler;
import com.example.blogs.security.handler.UserAuthenticationEntryPointHandler;
import com.example.blogs.security.jwt.JWTAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @create: 2021/12/8
 * @author: fb
 * @Description: SpringSecurity配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserAuthenticationEntryPointHandler userAuthenticationEntryPointHandler;

    @Resource
    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//            .antMatchers(ArrayUtil.toArray(Optional.ofNullable(JWTConstant.antMatchers).orElse(new ArrayList<>()), String.class)).permitAll()
//            .antMatchers("/v1/back/**/**").authenticated()
                //测试
                .anyRequest().permitAll()
                .and()
                .httpBasic().authenticationEntryPoint(userAuthenticationEntryPointHandler)
                .and()
                .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().cacheControl();
        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(
                        "doc.html",
                        "/**/swagger-ui.html",
                        "/**/*.html",
                        "/**/*.js",
                        "/**/*.css",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.jpg",
                        "/**/*.ico",
                        "/**/*.ttf",
                        "/swagger-resources/**",
                        "/swagger/**",
                        "/**/v2/api-docs",
                        "/webjars/springfox-swagger-ui/**"
                );
    }
}
