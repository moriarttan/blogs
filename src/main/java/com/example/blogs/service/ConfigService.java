package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.ConfigDTO;
import com.example.blogs.vo.ConfigVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Config;


/**
* 网站设置表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface ConfigService extends IService<Config> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link ConfigVO}
    */
    Result<Page<ConfigVO>> pageList(ConfigDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(ConfigDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(ConfigDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<ConfigVO>}
    */
    ConfigVO info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);
}