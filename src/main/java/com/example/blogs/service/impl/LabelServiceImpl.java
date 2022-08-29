package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.enums.DeletedEnum;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.LabelDTO;
import com.example.blogs.vo.LabelVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Label;
import com.example.blogs.mapper.LabelMapper;
import com.example.blogs.service.LabelService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* 标签表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements LabelService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link LabelVO}
    */
    @Override
    public Result<Page<LabelVO>> pageList(LabelDTO dto) {
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
    public Result<?> add(LabelDTO dto) {
    Label label = CopyUtil.transfer(dto, Label.class);
        int tag = baseMapper.insert(label);
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
    public Result<?> update(LabelDTO dto) {
    Label label = CopyUtil.transfer(dto, Label.class);
        int tag = baseMapper.updateById(label);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<LabelVO>}
    */
    @Override
    public Result<LabelVO> info(Long id) {
        Label label = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(label, LabelVO.class));
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

    /**
     * 列表
     * @param dto 筛选条件
     * @return
     */
    @Override
    public Result<List<LabelVO>> list(LabelDTO dto) {
        List<Label> labels = baseMapper.selectList(new LambdaQueryWrapper<Label>()
                .eq(Label::getDeleted, DeletedEnum.NOT_DELETED)
                .like(dto.getName() != null, Label::getName, dto.getName())
        );
        List<LabelVO> list = new ArrayList<>();
        for (Label label: labels) {
            list.add(CopyUtil.transfer(label, LabelVO.class));
        }
        return Result.success(list);
    }
}