package com.example.blogs.service.category;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Category;
import com.example.blogs.mapper.CategoryMapper;
import com.example.blogs.v1.back.dto.CategorySearchDTO;
import com.example.blogs.v1.back.dto.CategoryUpdateDTO;
import com.example.blogs.v1.back.vo.CategoryInfoVO;
import com.example.blogs.v1.back.vo.CategorySearchVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类
 * @author 15755
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * 分页列表
     * @param categorySearchDTO
     * @return
     */
    @Override
    public Result<Page<CategorySearchVO>> pageList(CategorySearchDTO categorySearchDTO) {
        return null;
    }

    /**
     * 所有列表
     * @return
     */
    @Override
    public Result<List<Category>> queryList() {
        return null;
    }

    /**
     * 新增
     * @param categoryUpdateDTO
     * @return
     */
    @Override
    public Result<?> add(CategoryUpdateDTO categoryUpdateDTO) {
        return null;
    }

    /**
     * 编辑
     * @param categoryUpdateDTO
     * @return
     */
    @Override
    public Result<?> update(CategoryUpdateDTO categoryUpdateDTO) {
        return null;
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @Override
    public Result<CategoryInfoVO> info(Integer id) {
        return null;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public Result<?> delete(Integer id) {
        return null;
    }
}
