package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.enums.GeneralStatusEnum;
import com.example.blogs.front.vo.LinkListVO;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.LinkDTO;
import com.example.blogs.vo.LinkVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Link;
import com.example.blogs.mapper.LinkMapper;
import com.example.blogs.service.LinkService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* 网站链接表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link LinkVO}
    */
    @Override
    public Result<Page<LinkVO>> pageList(LinkDTO dto) {
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
    public Result<?> add(LinkDTO dto) {
    Link link = CopyUtil.transfer(dto, Link.class);
        int tag = baseMapper.insert(link);
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
    public Result<?> update(LinkDTO dto) {
    Link link = CopyUtil.transfer(dto, Link.class);
        int tag = baseMapper.updateById(link);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<LinkVO>}
    */
    @Override
    public Result<LinkVO> info(Long id) {
        Link link = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(link, LinkVO.class));
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
    public List<LinkListVO> queryList() {
        List<Link> links = baseMapper.selectList(new LambdaQueryWrapper<Link>()
                .eq(Link::getDeleted, GeneralStatusEnum.NOT_DELETED.value())
                .orderByAsc(Link::getSort)
        );
        List<LinkListVO> list = new ArrayList<>();
        for (Link link: links) {
            list.add(CopyUtil.transfer(link, LinkListVO.class));
        }
        return list;
    }
}