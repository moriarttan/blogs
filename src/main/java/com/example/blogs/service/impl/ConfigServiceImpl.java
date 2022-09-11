package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.ConfigDTO;
import com.example.blogs.vo.ConfigVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Config;
import com.example.blogs.mapper.ConfigMapper;
import com.example.blogs.service.ConfigService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 网站设置表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link ConfigVO}
    */
    @Override
    public Result<Page<ConfigVO>> pageList(ConfigDTO dto) {
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
    public Result<?> add(ConfigDTO dto) {
    Config config = CopyUtil.transfer(dto, Config.class);
        int tag = baseMapper.insert(config);
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
    public Result<?> update(ConfigDTO dto) {
    Config config = CopyUtil.transfer(dto, Config.class);
        int tag = baseMapper.updateById(config);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link ConfigVO}
    */
    @Override
    public ConfigVO info(Long id) {
        Config config = baseMapper.selectById(id);
        return CopyUtil.transfer(config, ConfigVO.class);
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