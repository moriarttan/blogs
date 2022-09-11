package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.CommentDTO;
import com.example.blogs.vo.CommentVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Comment;
import com.example.blogs.mapper.CommentMapper;
import com.example.blogs.service.CommentService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 评论留言表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link CommentVO}
    */
    @Override
    public Page<CommentVO> pageList(CommentDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(),"create_time desc");
        return Page.toPage(baseMapper.pageList(dto));
    }

    /**
    * 新增
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> add(CommentDTO dto) {
    Comment comment = CopyUtil.transfer(dto, Comment.class);
        int tag = baseMapper.insert(comment);
        if(0 == tag){
            return Result.failed("新增操作失败");
        }
        return Result.success();
    }

    /**
    * 修改
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> update(CommentDTO dto) {
    Comment comment = CopyUtil.transfer(dto, Comment.class);
        int tag = baseMapper.updateById(comment);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<CommentVO>}
    */
    @Override
    public Result<CommentVO> info(Long id) {
        Comment comment = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(comment, CommentVO.class));
    }

    /**
    * 删除
    * @param id id
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> delete(Long id) {
        int tag = baseMapper.deleteById(id);
        if(0 == tag){
            return Result.failed("删除操作失败");
        }
        return Result.success();
    }
}