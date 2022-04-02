package com.example.blogs.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping("/test")
public class TestController {
    /**
     * 请求方式
     * GET, POST, PUT, DELETE
     * @return
     */
    @RequestMapping("/hello")
    public String hello () {
        return "Hello World!";
    }
}
