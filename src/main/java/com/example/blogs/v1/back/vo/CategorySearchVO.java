package com.example.blogs.v1.back.vo;

import com.example.blogs.domain.Category;
import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api(tags = "分类搜索返回")
public class CategorySearchVO extends Category {
}
