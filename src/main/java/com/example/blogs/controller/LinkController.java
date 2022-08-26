package com.example.blogs.controller;



import com.example.blogs.dto.LinkDTO;
import com.example.blogs.vo.LinkVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.LinkService;
import com.example.blogs.validation.GroupsAdd;
import com.example.blogs.validation.GroupsUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;


/**
* 网站链接表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/link")
@Api(value = "API - LinkController", tags = "网站链接表")
public class LinkController {

    @Resource
    private LinkService linkService;

    @PreAuthorize("hasAuthority('link:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<LinkVO>> pageList(LinkDTO dto) {
        return linkService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('link:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) LinkDTO dto) {
        return linkService.add(dto);
    }

    @PreAuthorize("hasAuthority('link:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) LinkDTO dto) {
        return linkService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<LinkVO> info(@Validated IdForm idForm) {
        return linkService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('link:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return linkService.delete(idForm.getId());
    }
}


