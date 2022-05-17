package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.domain.Config;

import com.example.blogs.front.vo.ConfigVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author 15755
 */
public interface ConfigMapper extends BaseMapper<Config> {
    /**
     * 获取网站设置
     */
    ConfigVo get(@Param("id") Integer id);

    /**
     * 浏览量统计
     */
    Integer setVisit(@Param("id") Integer id);
}