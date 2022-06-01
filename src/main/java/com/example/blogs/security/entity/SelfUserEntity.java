package com.example.blogs.security.entity;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @create: 2021/10/20
 * @author: fb
 * @Description: SpringSecurity用户的实体
 * 注意:这里必须要实现UserDetails接口
 */
@Data
public class SelfUserEntity implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户角色
     */
    private Collection<GrantedAuthority> authorities;
    /**
     * 单位ids
     */
    private List<Long> unitIds;

    /**
     * 账户是否过期
     */
    private boolean isAccountNonExpired = false;
    /**
     * 账户是否被锁定
     */
    private boolean isAccountNonLocked = false;
    /**
     * 证书是否过期
     */
    private boolean isCredentialsNonExpired = false;
    /**
     * 账户是否有效
     */
    private boolean isEnabled = true;

}
