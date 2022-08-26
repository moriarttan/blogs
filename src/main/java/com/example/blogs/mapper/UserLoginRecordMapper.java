package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.UserLoginRecordDTO;
import com.example.blogs.vo.UserLoginRecordVO;
import com.example.blogs.entity.UserLoginRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 用户登录记录表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface UserLoginRecordMapper extends BaseMapper<UserLoginRecord> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<UserLoginRecordVO>}
    */
    List<UserLoginRecordVO> pageList(@Param("dto") UserLoginRecordDTO dto);
}