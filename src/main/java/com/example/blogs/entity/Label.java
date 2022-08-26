package com.example.blogs.entity;

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
@ApiModel(value = "Label对象", description = "标签表")
public class Label implements Serializable {

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



    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name=" + name +
                ", sort=" + sort +
                ", deleted=" + deleted +
                ", createUserId=" + createUserId +
                ", createUsername=" + createUsername +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateUsername=" + updateUsername +
                ", updateTime=" + updateTime +
        "}";
    }

}
