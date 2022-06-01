package com.example.blogs.v1.admin.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.service.about.AboutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Api(tags = "关于我们")
@RequestMapping("v1/admin/about")
public class AboutController {

    @Autowired
    AboutService aboutService;

    @ApiOperation("分页列表")
    @RequestMapping("/pageList")
    public Result<Page<About>> pageList() {
        return aboutService.pageList();
    }

    @ApiOperation("列表")
    @RequestMapping("/list")
    public Result<List<About>> list() {
        return aboutService.queryList();
    }

    @ApiOperation("添加")
    @RequestMapping("/add")
    public Result<?> add() {
        return aboutService.exAdd();
    }

    @ApiOperation("修改")
    @RequestMapping("/update")
    public Result<?> update() {
        return aboutService.exUpdate();
    }

    @ApiOperation("详情")
    @RequestMapping("/info")
    public Result<?> info() {
        return aboutService.exInfo();
    }

    @ApiOperation("删除")
    @RequestMapping("/delete")
    public Result<?> delete() {
        return aboutService.exDelete();
    }
}
