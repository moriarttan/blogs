package com.example.blogs.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 注册
 * @author: Mr言覃
 * @create: 2022-11-15 00:59
 **/
@Data
@ApiModel(value = "RegisterDTO", description = "注册")
public class RegisterDTO {
    @NotNull(message = "账号不为空")
    @ApiModelProperty("用户账号或手机号")
    @TableField("username")
    private String username;

    @NotNull(message = "密码不为空")
    @ApiModelProperty("用户密码")
    @TableField("password")
    private String password;
}
