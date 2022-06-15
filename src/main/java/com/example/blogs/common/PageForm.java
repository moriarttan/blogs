package com.example.blogs.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "分页列表查询页码页数")
public class PageForm {
    /**
     * 分页当前页码
     */
    @ApiModelProperty(value = "当前页码")
    private Integer pageNum = 1;
    /**
     * 分页每页条数
     */
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize = 20;
}
