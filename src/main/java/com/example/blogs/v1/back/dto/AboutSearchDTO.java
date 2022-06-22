package com.example.blogs.v1.back.dto;


import com.example.blogs.common.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 15755
 */
@Data
@ApiModel(description = "关于我们搜索参数")
public class AboutSearchDTO extends PageForm {

    @ApiModelProperty(value = "标题")
    private String title;
}
