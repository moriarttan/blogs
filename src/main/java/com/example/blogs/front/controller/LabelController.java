package com.example.blogs.front.controller;


import com.example.blogs.common.IdForm;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.dto.LabelDTO;
import com.example.blogs.service.LabelService;
import com.example.blogs.validation.GroupsAdd;
import com.example.blogs.validation.GroupsUpdate;
import com.example.blogs.vo.LabelVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;
import java.util.List;


/**
* 标签表 前端控制器
 * @author FF
 * @since 2022-08-27
*/
@RestController(value = "FrontLabelController")
@RequestMapping("v1/api/label")
@Api(value = "API - LabelController", tags = "标签表")
public class LabelController {

    @Resource
    private LabelService labelService;

    @ApiOperation("列表")
    @GetMapping("list")
    public Result<List<LabelVO>> list (LabelDTO dto) {
        return labelService.list(dto);
    }

}


