package com.example.blogs.v1.back.dto;

import com.example.blogs.common.PageForm;
import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api(tags = "分类搜索参数")
public class CategorySearchDTO extends PageForm {
}
