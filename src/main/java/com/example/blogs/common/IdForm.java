package com.example.blogs.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author fb
 * @version 1.0
 * @data 2021/9/3
 * @description 数据表主键id
 */
@Data
@ApiModel(description = "数据表主键id")
public class IdForm {

    @NotNull(message = "主键id不能为空")
    @ApiModelProperty(value = "主键id", required = true)
    private Long id;

}
