package com.example.blogs.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Config;
import com.example.blogs.front.vo.ConfigVo;
import com.example.blogs.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigService extends ServiceImpl<ConfigMapper, Config> {


    public Result<ConfigVo> get() {
        ConfigVo configVo = getBaseMapper().get(1);
        return Result.success(configVo);
    }

    public Result setVisit() {
        Integer i = getBaseMapper().setVisit(1);
        if (1 != i) {
            return Result.failed("浏览量设置失败");
        }
        return Result.success();
    }
}
