package com.example.blogs.dto;

import com.example.blogs.common.PageForm;
    import com.baomidou.mybatisplus.annotation.FieldFill;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* 标签表
*
* @author FF
* @since 2022-08-27
*/
@Data
@TableName("label")
@ApiModel(value = "LabelDTO对象", description = "标签表")
public class LabelDTO extends PageForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Long id;

    @ApiModelProperty("标签名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "是否已删除：0未删除；1已删除", hidden = true)
    @TableField("deleted")
    private Integer deleted;

    @ApiModelProperty(value = "创建人id", hidden = true)
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty(value = "创建人用户名", hidden = true)
    @TableField(value = "create_username", fill = FieldFill.INSERT)
    private String createUsername;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人id", hidden = true)
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private Long updateUserId;

    @ApiModelProperty(value = "修改人用户名", hidden = true)
    @TableField(value = "update_username", fill = FieldFill.INSERT_UPDATE)
    private String updateUsername;

    @ApiModelProperty(value = "修改时间", hidden = true)
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
