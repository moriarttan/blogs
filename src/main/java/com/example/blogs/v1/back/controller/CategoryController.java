package com.example.blogs.v1.back.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Category;
import com.example.blogs.service.category.CategoryService;
import com.example.blogs.v1.back.dto.CategorySearchDTO;
import com.example.blogs.v1.back.dto.CategoryUpdateDTO;
import com.example.blogs.v1.back.vo.CategoryInfoVO;
import com.example.blogs.v1.back.vo.CategorySearchVO;
import com.example.blogs.validated.ValidatedId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Api(tags = "分类")
@RequestMapping("v1/admin/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @ApiOperation("分页列表")
    @GetMapping("/pageList")
    public Result<Page<CategorySearchVO>> pageList(CategorySearchDTO categorySearchDTO) {
        return categoryService.pageList(categorySearchDTO);
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<List<Category>> list() {
        return categoryService.queryList();
    }

    @ApiOperation("添加")
    @PostMapping("/add")
    public Result<?> add(@RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        return categoryService.add(categoryUpdateDTO);
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public Result<?> update(@RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        return categoryService.update(categoryUpdateDTO);
    }

    @ApiOperation("详情")
    @PostMapping("/info")
    public Result<CategoryInfoVO> info(@RequestBody ValidatedId id) {
        return categoryService.info(id.getId());
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody ValidatedId id) {
        return categoryService.delete(id.getId());
    }
}
