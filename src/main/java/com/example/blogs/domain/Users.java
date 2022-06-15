package com.example.blogs.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 */
@Data
@TableName("users")
public class Users implements Serializable {

    /**
     * 用户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 用户手机
     */
    private String phone;

    /**
     * 登录账号
     */
    private String login;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户行吧
     */
    private Integer sex;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Data careteTime;

    /**
     * 修改时间
     */
    private Data updateTime;

    /**
     * 是否删除：0未删除 1已删除
     */
    private Integer deleted;

    /**
     * 状态：0禁用 1启用
     */
    private Integer state;
}
