package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.enums.CommonEnum;
import com.example.blogs.front.vo.CategoryListVO;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.CategoryDTO;
import com.example.blogs.vo.CategoryVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Category;
import com.example.blogs.mapper.CategoryMapper;
import com.example.blogs.service.CategoryService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* 分类表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link CategoryVO}
    */
    @Override
    public Result<Page<CategoryVO>> pageList(CategoryDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(),"create_time desc");
        return Result.success(Page.toPage(baseMapper.pageList(dto)));
    }

    /**
    * 新增
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> add(CategoryDTO dto) {
    Category category = CopyUtil.transfer(dto, Category.class);
        int tag = baseMapper.insert(category);
        if(0 == tag){
            return Result.failed("新增操作失败");
        }
        return Result.success();
    }

    /**
    * 修改
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> update(CategoryDTO dto) {
    Category category = CopyUtil.transfer(dto, Category.class);
        int tag = baseMapper.updateById(category);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<CategoryVO>}
    */
    @Override
    public Result<CategoryVO> info(Long id) {
        Category category = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(category, CategoryVO.class));
    }

    /**
    * 删除
    * @param id id
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> delete(Long id) {
        int tag = baseMapper.deleteById(id);
        if(0 == tag){
            return Result.failed("删除操作失败");
        }
        return Result.success();
    }

    /**
     * 前台列表
     * @return
     */
    @Override
    public List<CategoryListVO> queryList(Long parentId) {
        List<Category> list = baseMapper.selectList(new LambdaQueryWrapper<Category>()
                .eq(Category::getDeleted, CommonEnum.NOT_DELETED.value())
                .eq(parentId != null, Category::getParentId, parentId)
                .orderByAsc(Category::getSort)
        );
        List<CategoryListVO> listVOS = new ArrayList<>();
        for (Category category: list) {
            listVOS.add(CopyUtil.transfer(category, CategoryListVO.class));
        }
        return listVOS;
    }
}