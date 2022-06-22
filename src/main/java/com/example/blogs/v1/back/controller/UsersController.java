package com.example.blogs.v1.back.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.service.users.UsersService;
import com.example.blogs.v1.back.dto.UsersDTO;
import com.example.blogs.v1.back.vo.UsersVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "用户")
@RequestMapping("v1/admin/users")
public class UsersController {
    UsersService usersService;

    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<UsersVO>> pageList(@Validated UsersDTO usersDTO) {
        return usersService.pageList(usersDTO);
    }

    @ApiOperation("列表")
    @RequestMapping("/list")
    public String list() {
        return "list";
    }

    @ApiOperation("添加")
    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @ApiOperation("修改")
    @RequestMapping("/update")
    public String update() {
        return "update";
    }

    @ApiOperation("详情")
    @RequestMapping("/info")
    public String info() {
        return "info";
    }

    @ApiOperation("删除")
    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }
}
