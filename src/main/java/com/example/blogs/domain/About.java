package com.example.blogs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 15755
 */
@Data
@ApiModel("关于我们")
public class About {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("点赞数")
    private Integer likeNumber;

    @ApiModelProperty("浏览数")
    private Integer visitNumber;

    @ApiModelProperty("文字数")
    private Integer sizeNumber;

    @ApiModelProperty("是否允许点赞：0否 1是")
    private Integer isLike;

    @ApiModelProperty("是否允许评论：0否 1是")
    private Integer isComment;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}