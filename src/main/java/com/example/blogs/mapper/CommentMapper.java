package com.example.blogs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blogs.dto.CommentDTO;
import com.example.blogs.vo.CommentVO;
import com.example.blogs.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 评论留言表  Mapper 接口
* @author FF
* @since 2022-08-27
*/
public interface CommentMapper extends BaseMapper<Comment> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<CommentVO>}
    */
    List<CommentVO> pageList(@Param("dto") CommentDTO dto);
}