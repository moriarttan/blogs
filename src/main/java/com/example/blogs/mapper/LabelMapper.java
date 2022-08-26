package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.LabelDTO;
import com.example.blogs.vo.LabelVO;
import com.example.blogs.entity.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 标签表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface LabelMapper extends BaseMapper<Label> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<LabelVO>}
    */
    List<LabelVO> pageList(@Param("dto") LabelDTO dto);
}