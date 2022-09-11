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
@TableName("category")
@ApiModel(value = "CategoryFrontVO", description = "分类")
public class CategoryListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Long id;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;
}
