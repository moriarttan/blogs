package com.example.blogs.front.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.dto.CommentDTO;
import com.example.blogs.front.vo.CommentListVO;
import com.example.blogs.service.CommentService;
import com.example.blogs.utils.CopyUtil;
import com.example.blogs.vo.CommentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 评论
 * @author: Mr言覃
 * @create: 2022-09-11 13:10
 **/
@RestController(value = "FrontCommentController")
@RequestMapping("v1/front/Comment")
@Api(value = "API - CommentController", tags = "文章")
public class CommentController {

    @Resource
    private CommentService CommentService;

    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<CommentListVO>> queryList(CommentDTO dto) {
        Page<CommentVO> pages = CommentService.pageList(dto);
        Page<CommentListVO> res = new Page<>();

        List<CommentListVO> list = new ArrayList<>();
        for (CommentVO vo: pages.getRows()) {
            list.add(CopyUtil.transfer(vo, CommentListVO.class));
        }
        res.setRows(list);
        res.setPageNum(pages.getPageNum());
        res.setPageSize(pages.getPageSize());
        res.setTotal(pages.getTotal());
        res.setTotalSize(pages.getTotalSize());
        res.setTotalPage(pages.getTotalPage());

        return Result.success(res);
    }
}
