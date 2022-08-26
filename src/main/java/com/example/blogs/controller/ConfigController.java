package com.example.blogs.controller;



import com.example.blogs.dto.ConfigDTO;
import com.example.blogs.vo.ConfigVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.ConfigService;
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
* 网站设置表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/config")
@Api(value = "API - ConfigController", tags = "网站设置表")
public class ConfigController {

    @Resource
    private ConfigService configService;

    @PreAuthorize("hasAuthority('config:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<ConfigVO>> pageList(ConfigDTO dto) {
        return configService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('config:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) ConfigDTO dto) {
        return configService.add(dto);
    }

    @PreAuthorize("hasAuthority('config:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) ConfigDTO dto) {
        return configService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<ConfigVO> info(@Validated IdForm idForm) {
        return configService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('config:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return configService.delete(idForm.getId());
    }
}


