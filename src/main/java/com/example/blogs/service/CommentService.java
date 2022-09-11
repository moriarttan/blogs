package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.CommentDTO;
import com.example.blogs.vo.CommentVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Comment;


/**
* 评论留言表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface CommentService extends IService<Comment> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link CommentVO}
    */
    Page<CommentVO> pageList(CommentDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(CommentDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(CommentDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<CommentVO>}
    */
    Result<CommentVO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);
}