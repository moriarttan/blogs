package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.ConfigDTO;
import com.example.blogs.vo.ConfigVO;
import com.example.blogs.entity.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 网站设置表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface ConfigMapper extends BaseMapper<Config> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<ConfigVO>}
    */
    List<ConfigVO> pageList(@Param("dto") ConfigDTO dto);
}