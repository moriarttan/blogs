package com.example.blogs.back.controller;



import cn.hutool.crypto.SecureUtil;
import cn.hutool.log.Log;
import com.example.blogs.back.dto.LoginDTO;
import com.example.blogs.dto.UserDTO;
import com.example.blogs.entity.User;
import com.example.blogs.enums.CommonEnum;
import com.example.blogs.vo.UserVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.UserService;
import com.example.blogs.validation.GroupsAdd;
import com.example.blogs.validation.GroupsUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;


/**
* 用户表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@Slf4j
@RestController
@RequestMapping("v1/back/user")
@Api(value = "API - UserController", tags = "用户表")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("登陆")
    @PostMapping("login")
    public Result<?> login(LoginDTO dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        // 用户名密码解密 start
        // 用户名密码解密 end

        // 验证码校验 start
        // 验证码校验 end

        // 验证用户是否有效
        User user = userService.queryUserByUsername(dto.getUsername());
        Result result = checkUserIsEffective(user);
        if (!Result.isSuccess(result)) {
            return result;
        }
        // 校验密码是否正确
        if (user.getPassword().equals(SecureUtil.md5(password))) {
            return Result.failed("登陆失败，密码不正确！");
        }

        // 登陆处理
        String token = "";
        return Result.success(token);
    }


    /**
     * 用户校验
     * @param user
     * @return
     */
    public Result<?> checkUserIsEffective(User user) {
        if (null == user) {
            log.info("登陆用户不存在");
            return Result.failed("登陆用户不存在");
        }
        if (CommonEnum.DELETED.value().equals(user.getDeleted())) {
            log.info("登陆用户账号已注销");
            return Result.failed("登陆用户账号已注销");
        }
        if (CommonEnum.FAIL.value().equals(user.getStatus())) {
            log.info("登陆用户账号冻结");
            return Result.failed("登陆用户账号已冻结");
        }
        return Result.success();
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public Result<?> register(@RequestBody UserDTO dto) {
        Result result = userService.register(dto);
        if (!Result.isSuccess(result)) {
            return result;
        }
        return Result.success();
    }

    @PreAuthorize("hasAuthority('user:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<UserVO>> pageList(UserDTO dto) {
        return Result.success(userService.pageList(dto));
    }

    @PreAuthorize("hasAuthority('user:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) UserDTO dto) {
        if (0 == userService.add(dto)) {
            return Result.failed("新增操作失败");
        }
        return Result.success();
    }

    @PreAuthorize("hasAuthority('user:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) UserDTO dto) {
        if (0 == userService.update(dto)) {
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<UserVO> info(@Validated IdForm idForm) {
        return Result.success(userService.info(idForm.getId()));
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        if (userService.delete(idForm.getId()) == 0) {
            return Result.failed("删除操作失败");
        }
        return Result.success();
    }
}


