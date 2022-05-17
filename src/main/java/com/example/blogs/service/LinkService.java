package com.example.blogs.service;

import com.example.blogs.common.Result;
import com.example.blogs.domain.Link;
import com.example.blogs.mapper.LinkMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LinkService {

    @Resource
    private LinkMapper linkMapper;

    public Result<List<Link>> list() {
        List<Link> list = linkMapper.selectByExample(null);
        return Result.success(list);
    }
}
