package com.example.blogs.back.controller;



import com.example.blogs.dto.ArticleDTO;
import com.example.blogs.vo.ArticleVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.ArticleService;
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
* 文章表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/article")
@Api(value = "API - ArticleController", tags = "文章表")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PreAuthorize("hasAuthority('article:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<ArticleVO>> pageList(ArticleDTO dto) {
        return articleService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('article:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) ArticleDTO dto) {
        return articleService.add(dto);
    }

    @PreAuthorize("hasAuthority('article:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) ArticleDTO dto) {
        return articleService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<ArticleVO> info(@Validated IdForm idForm) {
        return articleService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('article:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return articleService.delete(idForm.getId());
    }
}


