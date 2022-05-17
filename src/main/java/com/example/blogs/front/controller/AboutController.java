package com.example.blogs.front.controller;

import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.front.vo.AboutVo;
import com.example.blogs.service.AboutService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 关于我们-controller层
 * */
@RestController
@RequestMapping("/front/about")
public class AboutController {

    @Resource
    private AboutService aboutService;

    /** 获取列表
     * @return 返回
     * */
    @RequestMapping("/list")
    public Result<List<About>> list() {
        return aboutService.selectList();
    }
}
