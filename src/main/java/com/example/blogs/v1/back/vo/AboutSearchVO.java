package com.example.blogs.v1.back.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 15755
 */
@Data
@Api(tags = "关于我们列表返回")
public class AboutSearchVO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "点赞数")
    private Integer likeNumber;

    @ApiModelProperty(value = "浏览数")
    private Integer visitNumber;

    @ApiModelProperty(value = "文字数")
    private Integer sizeNumber;

    @ApiModelProperty(value = "是否允许点赞：0否，1是")
    private Integer isLike;

    @ApiModelProperty(value = "是否允许评论：0否，1是")
    private Integer isComment;
}
