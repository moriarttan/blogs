package com.example.blogs.front.controller;

import com.example.blogs.common.Result;
import com.example.blogs.service.ConfigService;
import com.example.blogs.vo.ConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 网站配置
 * @author: Mr言覃
 * @create: 2022-09-11 04:32
 **/
@RestController(value = "FrontConfigController")
@RequestMapping("v1/front/config")
@Api(value = "API - ConfigController", tags = "网站配置")
public class ConfigController {

    @Resource
    private ConfigService configService;

    @ApiOperation("获取网站配置")
    @GetMapping("get")
    public Result<ConfigVO> get() {
        return Result.success(configService.info(1L));
    }
}
