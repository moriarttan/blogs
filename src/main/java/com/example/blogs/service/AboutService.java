package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.domain.Link;
import com.example.blogs.mapper.AboutMapper;
import com.example.blogs.mapper.LinkMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 关于我们-服务层
 * @author 15755
 */
@Service
public class AboutService extends ServiceImpl<AboutMapper, About> {


    /**
    * @Description: 查询列表
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/5/6
    */
    public Result<List<About>> selectList() {
        List<About> list = getBaseMapper().selectList(null);
        return Result.success(list);
    }
}
