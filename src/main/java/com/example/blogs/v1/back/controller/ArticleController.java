package com.example.blogs.v1.back.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Article;
import com.example.blogs.service.article.ArticleService;
import com.example.blogs.v1.back.dto.ArticleSearchDTO;
import com.example.blogs.v1.back.dto.ArticleUpdateDTO;
import com.example.blogs.v1.back.vo.ArticleInfoVO;
import com.example.blogs.v1.back.vo.ArticleSearchVO;
import com.example.blogs.validated.ValidatedId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章管理
 * @author 15755
 */
@Controller
@Api(tags = "文章")
@RequestMapping("v1/admin/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @ApiOperation("分页列表")
    @GetMapping("/pageList")
    public Result<Page<ArticleSearchVO>> pageList(ArticleSearchDTO articleSearchDTO) {
        return articleService.pageList(articleSearchDTO);
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<List<Article>> list() {
        return articleService.queryList();
    }

    @ApiOperation("添加")
    @PostMapping("/add")
    public Result<?> add(@RequestBody ArticleUpdateDTO articleUpdateDTO) {
        return articleService.add(articleUpdateDTO);
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public Result<?> update(@RequestBody ArticleUpdateDTO articleUpdateDTO) {
        return articleService.update(articleUpdateDTO);
    }

    @ApiOperation("详情")
    @PostMapping("/info")
    public Result<ArticleInfoVO> info(@RequestBody ValidatedId id) {
        return articleService.info(id.getId());
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody ValidatedId id) {
        return articleService.delete(id.getId());
    }
}
