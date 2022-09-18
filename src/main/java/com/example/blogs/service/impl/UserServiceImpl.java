package com.example.blogs.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.back.dto.LoginDTO;
import com.example.blogs.enums.CommonEnum;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.UserDTO;
import com.example.blogs.vo.UserVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.entity.User;
import com.example.blogs.mapper.UserMapper;
import com.example.blogs.service.UserService;
import com.example.blogs.utils.CopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 用户表 服务实现类
* @author Mr言覃
* @since 2022-09-12
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 根据用户昵称查询用户
     * @param dto
     * @return
     */
    @Override
    public User queryUserByUsername(String username) {
        User user = baseMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .last("limit 1")
        );
        return user;
    }
    /**
     * 根据用户手机号查询用户
     * @param username
     * @return
     */
    public User queryUserByPhone(String username) {
        User user = baseMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .last("limit 1")
        );
        return user;
    }

    /**
     * 注册用户
     * @param dto dto
     * @return
     */
    @Override
    public Result<?> register(UserDTO dto) {
        Assert.isTrue(dto.getPassword() != null, "未设置密码");

        User user = queryUserByUsername(dto.getUsername());
        Assert.isTrue(null == user, "用户已存在");

        dto.setPassword(SecureUtil.md5(dto.getPassword()));
        if (0 == add(dto)) {
            return Result.failed("注册失败");
        }

        return Result.success();
    }

    /**
     * 分页列表
     *
     * @param dto 分页列表查询页码页数
     * @return {@link UserVO}
     */
    @Override
    public Page<UserVO> pageList(UserDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(),"create_time desc");
        return Page.toPage(baseMapper.pageList(dto));
    }

    /**
     * 新增
     *
     * @param dto 新增/修改参数
     * @return {@link Result}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(UserDTO dto) {
        User user = CopyUtil.transfer(dto, User.class);
        return baseMapper.insert(user);
    }

    /**
     * 修改
     *
     * @param dto 新增/修改参数
     * @return {@link Result}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(UserDTO dto) {
        User user = CopyUtil.transfer(dto, User.class);

        return baseMapper.updateById(user);
    }

    /**
     * 详情
     *
     * @param id id
     * @return {@link Result<UserVO>}
     */
    @Override
    public UserVO info(Long id) {
        User user = baseMapper.selectById(id);
        return CopyUtil.transfer(user, UserVO.class);
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link Result}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long id) {
        User user = baseMapper.selectById(id);
        user.setDeleted(CommonEnum.DELETED.value());

        return baseMapper.updateById(user);
    }
}