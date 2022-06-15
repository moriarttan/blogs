package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.domain.Users;
import com.example.blogs.test.domain.Test;
import com.example.blogs.v1.admin.dto.UsersDTO;
import com.example.blogs.v1.admin.vo.UsersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层
 */
public interface UsersMapper extends BaseMapper<Users> {

    List<UsersVO> pageList(@Param("usersDTO") UsersDTO usersDTO);
}
