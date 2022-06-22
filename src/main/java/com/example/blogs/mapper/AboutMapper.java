package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.domain.About;
import com.example.blogs.v1.back.dto.AboutSearchDTO;
import com.example.blogs.v1.back.vo.AboutSearchVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AboutMapper extends BaseMapper<About> {

    /**
     * 分页列表
     * @param searchDTO
     * @return
     */
    List<AboutSearchVO> pageList(@Param("searchDTO") AboutSearchDTO searchDTO);
}