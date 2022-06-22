package com.example.blogs.v1.back.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "评论")
@RequestMapping("v1/admin/comment")
public class CommentController {

    @ApiOperation("分页列表")
    @RequestMapping("/pageList")
    public String pageList() {
        return "pageList";
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
