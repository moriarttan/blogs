package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.back.dto.LoginDTO;
import com.example.blogs.dto.UserDTO;
import com.example.blogs.vo.UserVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.entity.User;


/**
* 用户表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface UserService extends IService<User> {


    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return
     */
    User queryUserByUsername(String username);

    /**
     * 注册用户
     * @param dto dto
     * @return {@link Result}
     */
    Result<?> register(UserDTO dto);

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link UserVO}
    */
    Page<UserVO> pageList(UserDTO dto);


    /**
     * 新增
     *
     * @param dto 新增/修改参数
     * @return {@link Result}
     */
    Integer add(UserDTO dto);

    /**
     * 修改
     *
     * @param dto 新增/修改参数
     * @return {@link Result}
     */
    Integer update(UserDTO dto);

    /**
     * 详情
     *
     * @param id id
     * @return {@link Result<UserVO>}
     */
    UserVO info(Long id);

    /**
     * 删除
     *
     * @param id id
     * @return {@link Result}
     */
    Integer delete(Long id);

}