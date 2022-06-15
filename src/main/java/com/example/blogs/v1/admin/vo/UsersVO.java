package com.example.blogs.v1.admin.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户分页搜索返回")
public class UsersVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户手机")
    private String phone;

    @ApiModelProperty(value = "登录账号")
    private String login;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户行吧")
    private Integer sex;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private Data careteTime;

    @ApiModelProperty(value = "修改时间")
    private Data updateTime;

    @ApiModelProperty(value = "状态：0禁用 1启用")
    private Integer state;
}
