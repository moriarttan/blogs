package com.example.blogs.front.controller;


import com.example.blogs.common.Result;
import com.example.blogs.front.vo.AboutListVO;
import com.example.blogs.front.vo.CategoryListVO;
import com.example.blogs.service.AboutService;
import com.example.blogs.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @description: 关于我
 *
 * @author: Mr言覃
 *
 * @create: 2022-09-11 04:41
 **/
@RestController(value = "FrontCategoryController")
@RequestMapping("v1/front/category")
@Api(value = "API - CategoryController", tags = "分类")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @ApiOperation("列表")
    @GetMapping("list")
    public Result<List<CategoryListVO>> queryList(Long parentId) {
        return Result.success(categoryService.queryList(parentId));
    }
}