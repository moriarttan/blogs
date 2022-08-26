package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.CategoryDTO;
import com.example.blogs.vo.CategoryVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Category;


/**
* 分类表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface CategoryService extends IService<Category> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link CategoryVO}
    */
    Result<Page<CategoryVO>> pageList(CategoryDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(CategoryDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(CategoryDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<CategoryVO>}
    */
    Result<CategoryVO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);
}