package com.example.blogs.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 登陆
 * @author: Mr言覃
 * @create: 2022-09-12 22:05
 **/
@Data
@ApiModel(value = "LoginDTO", description = "登陆")
public class LoginDTO {

    @ApiModelProperty("用户账号或手机号")
    @TableField("username")
    private String username;

    @ApiModelProperty("用户密码")
    @TableField("password")
    private String password;
}
