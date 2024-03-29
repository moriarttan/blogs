package com.example.blogs.vo;

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
* 网站链接表
*
* @author FF
* @since 2022-08-27
*/
@Data
@TableName("link")
@ApiModel(value = "LinkVO对象", description = "网站链接表")
public class LinkVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("链接名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

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

    @ApiModelProperty("链接地址")
    @TableField("link")
    private String link;

    @ApiModelProperty("链接图标")
    @TableField("icon")
    private String icon;


}
