package com.example.blogs.v1.back.vo;

import com.example.blogs.domain.Category;
import io.swagger.annotations.Api;
import lombok.Data;

/**
 * @author 15755
 */
@Data
@Api(tags = "分类详情返回")
public class CategoryInfoVO extends Category {
}
