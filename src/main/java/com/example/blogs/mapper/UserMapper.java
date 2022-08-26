package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.UserDTO;
import com.example.blogs.vo.UserVO;
import com.example.blogs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 用户表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface UserMapper extends BaseMapper<User> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<UserVO>}
    */
    List<UserVO> pageList(@Param("dto") UserDTO dto);
}