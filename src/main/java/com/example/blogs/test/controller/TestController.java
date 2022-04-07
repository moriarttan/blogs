package com.example.blogs.test.controller;

import com.example.blogs.service.TestService;
import com.example.blogs.test.domain.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;
    /**
     * 请求方式
     * GET, POST, PUT, DELETE
     * @return
     */
    @RequestMapping("/hello")
    public String hello () {
        return "Hello World!";
    }

    @RequestMapping("/list")
    public List<Test> list () {
        return testService.list();
    }
}
