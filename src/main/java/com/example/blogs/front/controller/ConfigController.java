package com.example.blogs.front.controller;

import com.example.blogs.common.Result;
import com.example.blogs.domain.Config;
import com.example.blogs.front.vo.ConfigVo;
import com.example.blogs.service.ConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/front/config")
public class ConfigController {

    @Resource
    private ConfigService configService;

    @RequestMapping("/get")
    public Result<ConfigVo> get() {
        return configService.get();
    }

    @RequestMapping("/setVisit")
    public Result setVisit() {
        return configService.setVisit();
    }
}
