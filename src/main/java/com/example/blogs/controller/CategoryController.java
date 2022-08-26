package com.example.blogs.controller;



import com.example.blogs.dto.CategoryDTO;
import com.example.blogs.vo.CategoryVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.CategoryService;
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
* 分类表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/category")
@Api(value = "API - CategoryController", tags = "分类表")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PreAuthorize("hasAuthority('category:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<CategoryVO>> pageList(CategoryDTO dto) {
        return categoryService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('category:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) CategoryDTO dto) {
        return categoryService.add(dto);
    }

    @PreAuthorize("hasAuthority('category:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) CategoryDTO dto) {
        return categoryService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<CategoryVO> info(@Validated IdForm idForm) {
        return categoryService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('category:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return categoryService.delete(idForm.getId());
    }
}


