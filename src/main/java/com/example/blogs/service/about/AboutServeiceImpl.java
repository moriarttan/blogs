package com.example.blogs.service.about;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.mapper.AboutMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutServeiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService {
    /**
    * @Description: 分页列表
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    @Override
    public Result<Page<About>> pageList() {
        return null;
    }


    /**
    * @Description: 列表
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    @Override
    public Result<List<About>> queryList() {
        List<About> list = getBaseMapper().selectList(null);
        return Result.success(list);
    }

    /**
    * @Description: 添加
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    @Override
    public Result<?> exAdd() {
        return Result.success(null);
    }

    /**
    * @Description: 编辑
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    @Override
    public Result<?> exUpdate() {
        return Result.success(null);
    }

    /**
    * @Description: 详情
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    @Override
    public Result<?> exInfo() {
        return Result.success(null);
    }

    /**
    * @Description: 删除
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    @Override
    public Result<?> exDelete() {
        return Result.success(null);
    }
}
