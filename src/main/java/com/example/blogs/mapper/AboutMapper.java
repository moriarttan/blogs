package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.AboutDTO;
import com.example.blogs.vo.AboutVO;
import com.example.blogs.entity.About;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 关于我  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface AboutMapper extends BaseMapper<About> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<AboutVO>}
    */
    List<AboutVO> pageList(@Param("dto") AboutDTO dto);
}