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
public class ArticleListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("点赞数")
    @TableField("like_number")
    private Integer likeNumber;

    @ApiModelProperty("浏览数")
    @TableField("visit_number")
    private Integer visitNumber;

    @ApiModelProperty("文字数")
    @TableField("size_number")
    private Integer sizeNumber;

    @ApiModelProperty("是否允许点赞：0 否，1 是")
    @TableField("`like`")
    private Boolean like;

    @ApiModelProperty("是否允许评论：0 否，1 是")
    @TableField("comment")
    private Boolean comment;

    @ApiModelProperty("状态：0 未发布，1 已发布")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
