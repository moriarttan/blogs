package com.example.blogs.v1.back.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.service.about.AboutService;
import com.example.blogs.v1.back.dto.AboutSearchDTO;
import com.example.blogs.v1.back.vo.AboutSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/** 关于我们
 * @author 15755
 */
@Api(tags = "关于我们")
@RestController("backAboutController")
@RequestMapping("v1/back/about")
public class AboutController {

    @Resource
    private AboutService aboutService;

    @ApiOperation("分页列表")
    @GetMapping("/pageList")
    public Result<Page<AboutSearchVO>> pageList(@Validated AboutSearchDTO searchDTO) {
        return aboutService.pageList(searchDTO);
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<List<About>> list() {
        return aboutService.queryList();
    }

    @ApiOperation("添加")
    @PostMapping("/add")
    public Result<?> add() {
        return aboutService.exAdd();
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public Result<?> update() {
        return aboutService.exUpdate();
    }

    @ApiOperation("详情")
    @PostMapping("/info")
    public Result<?> info() {
        return aboutService.exInfo();
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public Result<?> delete() {
        return aboutService.exDelete();
    }
}
