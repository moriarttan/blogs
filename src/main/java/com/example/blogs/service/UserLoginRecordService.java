package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.dto.UserLoginRecordDTO;
import com.example.blogs.vo.UserLoginRecordVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.UserLoginRecord;


/**
* 用户登录记录表  服务类接口
* @author FF
* @since 2022-08-27
*/
public interface UserLoginRecordService extends IService<UserLoginRecord> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link UserLoginRecordVO}
    */
    Result<Page<UserLoginRecordVO>> pageList(UserLoginRecordDTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(UserLoginRecordDTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(UserLoginRecordDTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<UserLoginRecordVO>}
    */
    Result<UserLoginRecordVO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);
}