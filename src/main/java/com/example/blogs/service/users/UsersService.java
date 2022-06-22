package com.example.blogs.service.users;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Users;
import com.example.blogs.v1.back.dto.UsersDTO;
import com.example.blogs.v1.back.vo.UsersVO;

public interface UsersService extends IService<Users> {
    Result<Page<UsersVO>> pageList(UsersDTO usersDTO);
}
