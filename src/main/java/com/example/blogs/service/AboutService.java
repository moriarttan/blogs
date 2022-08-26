package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.AboutDTO;
import com.example.blogs.vo.AboutVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.About;


/**
* 关于我  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface AboutService extends IService<About> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link AboutVO}
    */
    Result<Page<AboutVO>> pageList(AboutDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(AboutDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(AboutDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<AboutVO>}
    */
    Result<AboutVO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);
}