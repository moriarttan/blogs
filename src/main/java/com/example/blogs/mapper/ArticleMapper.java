package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.ArticleDTO;
import com.example.blogs.vo.ArticleVO;
import com.example.blogs.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 文章表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface ArticleMapper extends BaseMapper<Article> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<ArticleVO>}
    */
    List<ArticleVO> pageList(@Param("dto") ArticleDTO dto);
}