package com.example.blogs.validated;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 15755
 */
@Data
@ApiModel("请求参数")
public class ValidatedId {

    @ApiModelProperty("id")
    private Integer id;
}
