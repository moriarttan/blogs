package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.LinkDTO;
import com.example.blogs.front.vo.LinkListVO;
import com.example.blogs.vo.LinkVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Link;

import java.util.List;


/**
* 网站链接表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface LinkService extends IService<Link> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link LinkVO}
    */
    Result<Page<LinkVO>> pageList(LinkDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(LinkDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(LinkDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<LinkVO>}
    */
    Result<LinkVO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);

    /**
     * 前台查询列表
     * @return
     */
    List<LinkListVO> queryList();
}