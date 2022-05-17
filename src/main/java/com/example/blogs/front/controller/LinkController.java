package com.example.blogs.front.controller;

import com.example.blogs.common.Result;
import com.example.blogs.domain.Link;
import com.example.blogs.service.LinkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/front/link")
public class LinkController {

    @Resource
    public LinkService linkService;

    @RequestMapping("/list")
    public Result<List<Link>> list() {
        return linkService.list();
    }
}
