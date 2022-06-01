package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.domain.Config;

import org.apache.ibatis.annotations.Param;

/**
 * @author 15755
 */
public interface ConfigMapper extends BaseMapper<Config> {
    /**
     * 获取网站设置
     */
    Config get(@Param("id") Integer id);

    /**
     * 浏览量统计
     */
    Integer setVisit(@Param("id") Integer id);
}