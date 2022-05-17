package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.domain.About;
import com.example.blogs.domain.AboutExample;
import java.util.List;

import com.example.blogs.front.vo.AboutVo;
import org.apache.ibatis.annotations.Param;

public interface AboutMapper extends BaseMapper<About> {}