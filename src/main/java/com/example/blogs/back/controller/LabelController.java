package com.example.blogs.back.controller;



import com.example.blogs.dto.LabelDTO;
import com.example.blogs.vo.LabelVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.LabelService;
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
* 标签表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/label")
@Api(value = "API - LabelController", tags = "标签表")
public class LabelController {

    @Resource
    private LabelService labelService;

    @PreAuthorize("hasAuthority('label:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<LabelVO>> pageList(LabelDTO dto) {
        return labelService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('label:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) LabelDTO dto) {
        return labelService.add(dto);
    }

    @PreAuthorize("hasAuthority('label:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) LabelDTO dto) {
        return labelService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<LabelVO> info(@Validated IdForm idForm) {
        return labelService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('label:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return labelService.delete(idForm.getId());
    }
}


