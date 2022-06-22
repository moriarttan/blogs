package com.example.blogs.service.users;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Users;
import com.example.blogs.mapper.UsersMapper;
import com.example.blogs.v1.back.dto.UsersDTO;
import com.example.blogs.v1.back.vo.UsersVO;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Override
    public Result<Page<UsersVO>> pageList(UsersDTO usersDTO) {
        PageHelper.startPage(usersDTO.getPageNum(), usersDTO.getPageSize(), "create_time desc");
        List<UsersVO> list = baseMapper.pageList(usersDTO);
        return Result.success(Page.toPage(list));
    }
}
