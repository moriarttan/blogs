package com.example.blogs.front.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文章返回参数
 * @author Mr言覃
 * @description
 * @create 2022/9/11 03:00
 */
@Data
@TableName("article")
@ApiModel(value = "ArticleFrontVO", description = "文章")
public class CommentListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Long id;

    @ApiModelProperty("评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("是否隐私评论：0否，1是")
    @TableField("privacy")
    private Integer privacy;

    @ApiModelProperty("创建人用户名")
    @TableField(value = "create_username", fill = FieldFill.INSERT)
    private String createUsername;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}