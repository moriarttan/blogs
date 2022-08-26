package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.ArticleDTO;
import com.example.blogs.vo.ArticleVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Article;


/**
* 文章表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface ArticleService extends IService<Article> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link ArticleVO}
    */
    Result<Page<ArticleVO>> pageList(ArticleDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(ArticleDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(ArticleDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<ArticleVO>}
    */
    Result<ArticleVO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);
}