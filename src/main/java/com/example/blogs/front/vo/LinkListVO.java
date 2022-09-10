package com.example.blogs.front.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 网站链接返回参数
 * @author Mr言覃
 * @description
 * @create 2022/9/11 03:00
 */
@Data
@TableName("label")
@ApiModel(value = "LinkFrontVO", description = "网站链接")
public class LinkListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Long id;

    @ApiModelProperty("链接名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("链接地址")
    @TableField("link")
    private String link;

    @ApiModelProperty("链接图标")
    @TableField("icon")
    private String icon;
}
