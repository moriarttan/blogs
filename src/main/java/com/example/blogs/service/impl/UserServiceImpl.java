package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.UserDTO;
import com.example.blogs.vo.UserVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.User;
import com.example.blogs.mapper.UserMapper;
import com.example.blogs.service.UserService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 用户表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link UserVO}
    */
    @Override
    public Result<Page<UserVO>> pageList(UserDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(),"create_time desc");
        return Result.success(Page.toPage(baseMapper.pageList(dto)));
    }

    /**
    * 新增
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> add(UserDTO dto) {
    User user = CopyUtil.transfer(dto, User.class);
        int tag = baseMapper.insert(user);
        if(0 == tag){
            return Result.failed("新增操作失败");
        }
        return Result.success();
    }

    /**
    * 修改
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> update(UserDTO dto) {
    User user = CopyUtil.transfer(dto, User.class);
        int tag = baseMapper.updateById(user);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<UserVO>}
    */
    @Override
    public Result<UserVO> info(Long id) {
        User user = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(user, UserVO.class));
    }

    /**
    * 删除
    * @param id id
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> delete(Long id) {
        int tag = baseMapper.deleteById(id);
        if(0 == tag){
            return Result.failed("删除操作失败");
        }
        return Result.success();
    }
}