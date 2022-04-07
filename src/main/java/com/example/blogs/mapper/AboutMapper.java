package com.example.blogs.mapper;

import com.example.blogs.domain.About;
import com.example.blogs.domain.AboutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AboutMapper {
    long countByExample(AboutExample example);

    int deleteByExample(AboutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(About record);

    int insertSelective(About record);

    List<About> selectByExampleWithBLOBs(AboutExample example);

    List<About> selectByExample(AboutExample example);

    About selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") About record, @Param("example") AboutExample example);

    int updateByExampleWithBLOBs(@Param("record") About record, @Param("example") AboutExample example);

    int updateByExample(@Param("record") About record, @Param("example") AboutExample example);

    int updateByPrimaryKeySelective(About record);

    int updateByPrimaryKeyWithBLOBs(About record);

    int updateByPrimaryKey(About record);
}