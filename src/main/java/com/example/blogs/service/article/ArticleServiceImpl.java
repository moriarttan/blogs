package com.example.blogs.service.article;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.Article;
import com.example.blogs.mapper.ArticleMapper;
import com.example.blogs.v1.back.dto.ArticleSearchDTO;
import com.example.blogs.v1.back.dto.ArticleUpdateDTO;
import com.example.blogs.v1.back.vo.ArticleInfoVO;
import com.example.blogs.v1.back.vo.ArticleSearchVO;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    /**
     * @Description: 分页列表
     * @Param:
     * @return:
     * @Author: Mr.Tan
     * @Date: 2022/6/2
     */
    @Override
    public Result<Page<ArticleSearchVO>> pageList(ArticleSearchDTO searchDTO) {
        PageHelper.startPage(searchDTO.getPageNum(), searchDTO.getPageSize(), "create_time desc");
        List<ArticleSearchVO> list = baseMapper.pageList(searchDTO);

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
    public Result<List<Article>> queryList() {
        List<Article> list = getBaseMapper().selectList(null);
        return Result.success(list);
    }

    /**
     * 添加
     * @param articleUpdateDTO
     * @return
     */
    @Override
    public Result<?> add(ArticleUpdateDTO articleUpdateDTO) {
        Article article = BeanUtil.copyProperties(articleUpdateDTO, Article.class);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        baseMapper.insert(article);
        return Result.success();
    }

    @Override
    public Result<?> update(ArticleUpdateDTO articleUpdateDTO) {
        Article article = BeanUtil.copyProperties(articleUpdateDTO, Article.class);
        article.setUpdateTime(new Date());
        baseMapper.updateById(article);
        return Result.success();
    }

    @Override
    public Result<ArticleInfoVO> info(Integer id) {
        Article article = baseMapper.selectById(id);
        if (null == article) {
            return Result.failed("id不正确");
        }
        ArticleInfoVO articleInfoVO = BeanUtil.copyProperties(article, ArticleInfoVO.class);
        return Result.success(articleInfoVO);
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
