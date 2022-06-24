package com.example.blogs.v1.back.dto;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 15755
 */
@Data
@Api(tags = "关于我们新增/编辑参数")
public class AboutUpdateDTO {

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
}
