package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.LinkDTO;
import com.example.blogs.vo.LinkVO;
import com.example.blogs.entity.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 网站链接表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface LinkMapper extends BaseMapper<Link> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<LinkVO>}
    */
    List<LinkVO> pageList(@Param("dto") LinkDTO dto);
}