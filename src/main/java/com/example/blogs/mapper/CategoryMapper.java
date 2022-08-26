package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.CategoryDTO;
import com.example.blogs.vo.CategoryVO;
import com.example.blogs.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 分类表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface CategoryMapper extends BaseMapper<Category> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<CategoryVO>}
    */
    List<CategoryVO> pageList(@Param("dto") CategoryDTO dto);
}