package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.AboutDTO;
import com.example.blogs.vo.AboutVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.About;
import com.example.blogs.mapper.AboutMapper;
import com.example.blogs.service.AboutService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 关于我 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link AboutVO}
    */
    @Override
    public Result<Page<AboutVO>> pageList(AboutDTO dto) {
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
    public Result<?> add(AboutDTO dto) {
    About about = CopyUtil.transfer(dto, About.class);
        int tag = baseMapper.insert(about);
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
    public Result<?> update(AboutDTO dto) {
    About about = CopyUtil.transfer(dto, About.class);
        int tag = baseMapper.updateById(about);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<AboutVO>}
    */
    @Override
    public Result<AboutVO> info(Long id) {
        About about = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(about, AboutVO.class));
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