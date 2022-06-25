package com.example.blogs.v1.back.vo;

import com.example.blogs.domain.About;
import com.example.blogs.domain.Article;
import io.swagger.annotations.Api;
import lombok.Data;

/**
 * @author 15755
 */
@Data
@Api(tags = "文章详情返回参数")
public class ArticleInfoVO extends Article {
}
