package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.domain.About;
import com.example.blogs.domain.Article;

import java.util.List;

import com.example.blogs.v1.back.dto.ArticleSearchDTO;
import com.example.blogs.v1.back.vo.ArticleSearchVO;
import org.apache.ibatis.annotations.Param;

/**
 * 文章
 */
public interface ArticleMapper extends BaseMapper<Article> {
    List<ArticleSearchVO> pageList(@Param("searchDTO") ArticleSearchDTO searchDTO);
}