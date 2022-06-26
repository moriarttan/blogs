package com.example.blogs.service.category;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Category;
import com.example.blogs.v1.back.dto.CategorySearchDTO;
import com.example.blogs.v1.back.dto.CategoryUpdateDTO;
import com.example.blogs.v1.back.vo.CategoryInfoVO;
import com.example.blogs.v1.back.vo.CategorySearchVO;

import java.util.List;

/**
 * @author 15755
 */
public interface CategoryService extends IService<Category> {
    /**
     * 分页列表
     * @param categorySearchDTO
     * @return
     */
    Result<Page<CategorySearchVO>> pageList(CategorySearchDTO categorySearchDTO);

    /**
     * 所有列表
     * @return
     */
    Result<List<Category>> queryList();

    /**
     * 新增
     * @param categoryUpdateDTO
     * @return
     */
    Result<?> add(CategoryUpdateDTO categoryUpdateDTO);

    /**
     * 编辑
     * @param categoryUpdateDTO
     * @return
     */
    Result<?> update(CategoryUpdateDTO categoryUpdateDTO);

    /**
     * 详情
     * @param id
     * @return
     */
    Result<CategoryInfoVO> info(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    Result<?> delete(Integer id);
}
