package com.example.blogs.front.controller;


import com.example.blogs.common.Result;
import com.example.blogs.front.vo.LinkListVO;
import com.example.blogs.service.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @description: 网站链接
 *
 * @author: Mr言覃
 *
 * @create: 2022-09-11 04:41
 **/
@RestController(value = "FrontLinkController")
@RequestMapping("v1/front/link")
@Api(value = "API - LinkController", tags = "网站链接")
public class LinkController {

    @Resource
    private LinkService linkService;

    @ApiOperation("列表")
    @GetMapping("list")
    public Result<List<LinkListVO>> queryList() {


        return Result.success(linkService.queryList());
    }
}