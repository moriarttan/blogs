package com.example.blogs.back.controller;



import com.example.blogs.dto.CommentDTO;
import com.example.blogs.vo.CommentVO;
import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.service.CommentService;
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
* 评论留言表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController
@RequestMapping("v1/back/comment")
@Api(value = "API - CommentController", tags = "评论留言表")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PreAuthorize("hasAuthority('comment:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<CommentVO>> pageList(CommentDTO dto) {
        return commentService.pageList(dto);
    }

    @PreAuthorize("hasAuthority('comment:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) CommentDTO dto) {
        return commentService.add(dto);
    }

    @PreAuthorize("hasAuthority('comment:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) CommentDTO dto) {
        return commentService.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<CommentVO> info(@Validated IdForm idForm) {
        return commentService.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('comment:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return commentService.delete(idForm.getId());
    }
}


