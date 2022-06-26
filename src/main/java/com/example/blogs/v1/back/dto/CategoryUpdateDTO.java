package com.example.blogs.v1.back.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分类新增编辑
 */
@Data
@Api(tags = "分类新增/编辑参数")
public class CategoryUpdateDTO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("状态：0停用 1启用")
    private Byte status;

}
