package com.example.blogs.service.about;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.mapper.AboutMapper;
import com.example.blogs.v1.back.dto.AboutSearchDTO;
import com.example.blogs.v1.back.dto.AboutUpdateDTO;
import com.example.blogs.v1.back.vo.AboutInfoVO;
import com.example.blogs.v1.back.vo.AboutSearchVO;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Result<Page<AboutSearchVO>> pageList(AboutSearchDTO searchDTO) {
        PageHelper.startPage(searchDTO.getPageNum(), searchDTO.getPageSize(), "create_time desc");
        List<AboutSearchVO> list = baseMapper.pageList(searchDTO);

        return Result.success(Page.toPage(list));
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
     * 添加
     * @param aboutUpdateDTO
     * @return
     */
    @Override
    public Result<?> add(AboutUpdateDTO aboutUpdateDTO) {
        About about = BeanUtil.copyProperties(aboutUpdateDTO, About.class);
        about.setCreateTime(new Date());
        about.setUpdateTime(new Date());
        baseMapper.insert(about);
        return Result.success();
    }

    @Override
    public Result<?> update(AboutUpdateDTO aboutUpdateDTO) {
        About about = BeanUtil.copyProperties(aboutUpdateDTO, About.class);
        about.setUpdateTime(new Date());
        baseMapper.updateById(about);
        return Result.success();
    }

    @Override
    public Result<AboutInfoVO> info(Integer id) {
        About about = baseMapper.selectById(id);
        if (null == about) {
            return Result.failed("id不正确");
        }
        AboutInfoVO aboutInfoVO = BeanUtil.copyProperties(about, AboutInfoVO.class);
        return Result.success(aboutInfoVO);
    }

    @Override
    public Result<?> delete(Integer id) {
        Integer tag = baseMapper.deleteById(id);
        if (tag == 0) {
            return Result.failed("删除失败");
        }
        return Result.success();
    }
}
