package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.enums.CommonEnum;
import com.example.blogs.front.vo.AboutListVO;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.AboutDTO;
import com.example.blogs.vo.AboutVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.entity.About;
import com.example.blogs.mapper.AboutMapper;
import com.example.blogs.service.AboutService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<AboutListVO> queryList() {
        List<About> lists = baseMapper.selectList(new LambdaQueryWrapper<About>()
                .eq(About::getDeleted, CommonEnum.NOT_DELETED.value())
                .eq(About::getStatus, CommonEnum.PUBLISH.value())
                .orderByDesc(About::getCreateTime)
        );
        List<AboutListVO> list = new ArrayList<>();
        for (About about: lists) {
            list.add(CopyUtil.transfer(about, AboutListVO.class));
        }
        return list;
    }
}