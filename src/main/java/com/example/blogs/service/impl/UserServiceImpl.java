package com.example.blogs.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.dto.RegisterDTO;
import com.example.blogs.enums.CommonEnum;
import com.example.blogs.service.RedisService;
import com.example.blogs.vo.CurrentUserInfoVO;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* 用户表 服务实现类
* @author Mr言覃
* @since 2022-09-12
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RedisService redisService;

    /**
     * 根据用户昵称查询用户
     * @param username
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
    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterDTO dto) {
        //查询用户名是否重复
        User user = queryUserByUsername(dto.getUsername());
        Assert.isNull(user, "用户已存在");
        Assert.isTrue(isEmailCode(dto.getUsername(), dto.getEmailCode()), "验证码验证失败");

        //注册账号
        user = new User();
        user.setUsername(dto.getUsername());
        user.setPhone(dto.getPhone());
        user.setPassword(SecureUtil.md5(dto.getPassword()));
        int tag = baseMapper.insert(user);
        Assert.isTrue(tag != 0, "注册失败");
    }

    /**
     * 当前登录用户信息
     * @param dto
     * @return
     */
    @Override
    public CurrentUserInfoVO currentInfo(RegisterDTO dto) {
        return null;
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

    /**
     * 判断邮件验证码是否有效
     * @param email 邮箱账号
     * @param code 验证码
     * @return true|false
     */
    public boolean isEmailCode(String email, String code) {
        if (redisService.get(email).equals(code)) {
            redisService.del(email);
            return true;
        }
        return false;
    }
}