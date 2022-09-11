package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.LabelDTO;
import com.example.blogs.front.vo.LabelListVO;
import com.example.blogs.vo.LabelVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Label;

import java.util.List;


/**
* 标签表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface LabelService extends IService<Label> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link LabelVO}
    */
    Result<Page<LabelVO>> pageList(LabelDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(LabelDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(LabelDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<LabelVO>}
    */
    Result<LabelVO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);


    /**
     * 列表
     *
     * @return
     */
    List<LabelListVO> queryList();
}