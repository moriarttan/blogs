package com.example.blogs.v1.admin.dto;

import com.example.blogs.common.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户搜索参数")
public class UsersDTO extends PageForm {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String login;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 账号启用状态：0禁用 1启用
     */
    @ApiModelProperty(value = "账号启用状态：0禁用 1启用")
    private Integer status;
}
