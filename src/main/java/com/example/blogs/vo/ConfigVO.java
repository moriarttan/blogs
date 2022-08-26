package com.example.blogs.vo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* 网站设置表
*
* @author FF
* @since 2022-08-27
*/
@Data
@TableName("config")
@ApiModel(value = "ConfigVO对象", description = "网站设置表")
public class ConfigVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("网站名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("网站名称(英文)")
    @TableField("name_en")
    private String nameEn;

    @ApiModelProperty("网站备案号")
    @TableField("record_number")
    private String recordNumber;

    @ApiModelProperty("网站介绍")
    @TableField("website")
    private String website;

    @ApiModelProperty("浏览量统计")
    @TableField("visit_number")
    private Integer visitNumber;


}
