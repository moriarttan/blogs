package com.example.blogs.back.controller;



import com.example.blogs.dto.AboutDTO;
import com.example.blogs.vo.AboutVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.AboutService;
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
* 关于我 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/about")
@Api(value = "API - AboutController", tags = "关于我")
public class AboutController {

    @Resource
    private AboutService aboutService;

    @PreAuthorize("hasAuthority('about:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<AboutVO>> pageList(AboutDTO dto) {
        return aboutService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('about:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) AboutDTO dto) {
        return aboutService.add(dto);
    }

    @PreAuthorize("hasAuthority('about:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) AboutDTO dto) {
        return aboutService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<AboutVO> info(@Validated IdForm idForm) {
        return aboutService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('about:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return aboutService.delete(idForm.getId());
    }
}


