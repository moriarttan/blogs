package com.example.blogs.controller;



import com.example.blogs.dto.UserLoginRecordDTO;
import com.example.blogs.vo.UserLoginRecordVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.UserLoginRecordService;
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
* 用户登录记录表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/userLoginRecord")
@Api(value = "API - UserLoginRecordController", tags = "用户登录记录表")
public class UserLoginRecordController {

    @Resource
    private UserLoginRecordService userLoginRecordService;

    @PreAuthorize("hasAuthority('userLoginRecord:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<UserLoginRecordVO>> pageList(UserLoginRecordDTO dto) {
        return userLoginRecordService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('userLoginRecord:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) UserLoginRecordDTO dto) {
        return userLoginRecordService.add(dto);
    }

    @PreAuthorize("hasAuthority('userLoginRecord:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) UserLoginRecordDTO dto) {
        return userLoginRecordService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<UserLoginRecordVO> info(@Validated IdForm idForm) {
        return userLoginRecordService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('userLoginRecord:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return userLoginRecordService.delete(idForm.getId());
    }
}


