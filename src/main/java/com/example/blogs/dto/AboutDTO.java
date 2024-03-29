package com.example.blogs.dto;

import com.example.blogs.common.PageForm;
    import com.baomidou.mybatisplus.annotation.FieldFill;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* 关于我
*
* @author FF
* @since 2022-08-27
*/
@Data
@TableName("about")
@ApiModel(value = "AboutDTO对象", description = "关于我")
public class AboutDTO extends PageForm implements Serializable {

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
    @TableField("liked")
    private Boolean liked;

    @ApiModelProperty("是否允许评论：0 否，1 是")
    @TableField("commented")
    private Boolean commented;

    @ApiModelProperty("状态：0 未发布，1 已发布")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("是否已删除：0未删除；1已删除")
    @TableField("deleted")
    private Integer deleted;

    @ApiModelProperty("创建人id")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty("创建人用户名")
    @TableField(value = "create_username", fill = FieldFill.INSERT)
    private String createUsername;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改人id")
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private Long updateUserId;

    @ApiModelProperty("修改人用户名")
    @TableField(value = "update_username", fill = FieldFill.INSERT_UPDATE)
    private String updateUsername;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
