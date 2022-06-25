package com.example.blogs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 文章
 * @author 15755
 */
@Data
@ApiModel("文章")
public class Article {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("点赞数")
    private Integer likeNumber;

    @ApiModelProperty("浏览数")
    private Integer visitNumber;

    @ApiModelProperty("字数")
    private Integer sizeNumber;

    @ApiModelProperty("是否允许点赞：0否 1是")
    private Byte isLike;

    @ApiModelProperty("是否允许评论：0否 1是")
    private Byte isComment;

    @ApiModelProperty("状态：0停用 1启用")
    private Byte status;

    @ApiModelProperty("删除： 0未删除 1已删除")
    private Byte isDeleted;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", likeNumber=").append(likeNumber);
        sb.append(", visitNumber=").append(visitNumber);
        sb.append(", sizeNumber=").append(sizeNumber);
        sb.append(", isLike=").append(isLike);
        sb.append(", isComment=").append(isComment);
        sb.append(", status=").append(status);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}