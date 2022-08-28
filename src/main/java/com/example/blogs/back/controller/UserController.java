package com.example.blogs.back.controller;



import com.example.blogs.dto.UserDTO;
import com.example.blogs.vo.UserVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.UserService;
import com.example.blogs.validation.GroupsAdd;
import com.example.blogs.validation.GroupsUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;


/**
* 用户表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/user")
@Api(value = "API - UserController", tags = "用户表")
public class UserController {

    @Resource
    private UserService userService;

    @PreAuthorize("hasAuthority('user:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<UserVO>> pageList(UserDTO dto) {
        return userService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('user:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) UserDTO dto) {
        return userService.add(dto);
    }

    @PreAuthorize("hasAuthority('user:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) UserDTO dto) {
        return userService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<UserVO> info(@Validated IdForm idForm) {
        return userService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return userService.delete(idForm.getId());
    }
}


