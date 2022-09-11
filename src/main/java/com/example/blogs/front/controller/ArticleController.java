package com.example.blogs.front.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.dto.ArticleDTO;
import com.example.blogs.front.vo.AboutListVO;
import com.example.blogs.front.vo.ArticleListVO;
import com.example.blogs.service.ArticleService;
import com.example.blogs.utils.CopyUtil;
import com.example.blogs.vo.ArticleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 文章
 * @author: Mr言覃
 * @create: 2022-09-11 13:10
 **/
@RestController(value = "FrontArticleController")
@RequestMapping("v1/front/article")
@Api(value = "API - ArticleController", tags = "文章")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<ArticleListVO>> queryList(ArticleDTO dto) {
        Page<ArticleVO> pages = articleService.pageList(dto);
        Page<ArticleListVO> res = new Page<>();

        List<ArticleListVO> list = new ArrayList<>();
        for (ArticleVO vo: pages.getRows()) {
            list.add(CopyUtil.transfer(vo, ArticleListVO.class));
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
