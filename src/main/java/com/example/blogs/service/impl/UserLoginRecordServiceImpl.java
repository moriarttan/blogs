package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.UserLoginRecordDTO;
import com.example.blogs.vo.UserLoginRecordVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.UserLoginRecord;
import com.example.blogs.mapper.UserLoginRecordMapper;
import com.example.blogs.service.UserLoginRecordService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 用户登录记录表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements UserLoginRecordService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link UserLoginRecordVO}
    */
    @Override
    public Result<Page<UserLoginRecordVO>> pageList(UserLoginRecordDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(),"create_time desc");
        return Result.success(Page.toPage(baseMapper.pageList(dto)));
    }

    /**
    * 新增
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> add(UserLoginRecordDTO dto) {
    UserLoginRecord userLoginRecord = CopyUtil.transfer(dto, UserLoginRecord.class);
        int tag = baseMapper.insert(userLoginRecord);
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
    public Result<?> update(UserLoginRecordDTO dto) {
    UserLoginRecord userLoginRecord = CopyUtil.transfer(dto, UserLoginRecord.class);
        int tag = baseMapper.updateById(userLoginRecord);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<UserLoginRecordVO>}
    */
    @Override
    public Result<UserLoginRecordVO> info(Long id) {
        UserLoginRecord userLoginRecord = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(userLoginRecord, UserLoginRecordVO.class));
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