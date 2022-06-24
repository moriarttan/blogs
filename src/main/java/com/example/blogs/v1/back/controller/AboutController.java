package com.example.blogs.v1.back.controller;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.service.about.AboutService;
import com.example.blogs.v1.back.dto.AboutSearchDTO;
import com.example.blogs.v1.back.dto.AboutUpdateDTO;
import com.example.blogs.v1.back.vo.AboutInfoVO;
import com.example.blogs.v1.back.vo.AboutSearchVO;
import com.example.blogs.validated.ValidatedId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;
import java.util.List;

/** 关于我们
 * @author 15755
 */
@Api(tags = "关于我们")
@RestController("backAboutController")
@RequestMapping("v1/back/about")
public class AboutController {

    @Resource
    private AboutService aboutService;

    @ApiOperation("分页列表")
    @GetMapping("/pageList")
    public Result<Page<AboutSearchVO>> pageList(@Validated AboutSearchDTO searchDTO) {
        return aboutService.pageList(searchDTO);
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<List<About>> list() {
        return aboutService.queryList();
    }

    @ApiOperation("添加")
    @PostMapping("/add")
    public Result<?> add(@RequestBody AboutUpdateDTO aboutUpdateDTO) {
        return aboutService.add(aboutUpdateDTO);
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public Result<?> update(@RequestBody AboutUpdateDTO aboutUpdateDTO) {
        return aboutService.update(aboutUpdateDTO);
    }

    @ApiOperation("详情")
    @PostMapping("/info")
    public Result<AboutInfoVO> info(@RequestBody ValidatedId id) {
        return aboutService.info(id.getId());
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public Result<?> delete() {
        return aboutService.exDelete();
    }
}
