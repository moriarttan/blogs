package com.example.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blogs.back.vo.ArticleCountVO;
import com.example.blogs.enums.DeletedEnum;
import com.github.pagehelper.PageHelper;
import com.example.blogs.dto.ArticleDTO;
import com.example.blogs.vo.ArticleVO;
import com.example.blogs.common.Page;
import com.example.blogs.common.PageForm;
import com.example.blogs.common.Result;
import com.example.blogs.entity.Article;
import com.example.blogs.mapper.ArticleMapper;
import com.example.blogs.service.ArticleService;
import com.example.blogs.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* 文章表 服务实现类
* @author FF
* @since 2022-08-27
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link ArticleVO}
    */
    @Override
    public Page<ArticleVO> pageList(ArticleDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(),"create_time desc");
        return Page.toPage(baseMapper.pageList(dto));
    }

    /**
    * 新增
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> add(ArticleDTO dto) {
    Article article = CopyUtil.transfer(dto, Article.class);
        int tag = baseMapper.insert(article);
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
    public Result<?> update(ArticleDTO dto) {
    Article article = CopyUtil.transfer(dto, Article.class);
        int tag = baseMapper.updateById(article);
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<ArticleVO>}
    */
    @Override
    public Result<ArticleVO> info(Long id) {
        Article article = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(article, ArticleVO.class));
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
     * 获取文章统计
     * @return ArticleCountVO
     */
    @Override
    public ArticleCountVO getCount() {
        ArticleCountVO vo = new ArticleCountVO();
        int count = baseMapper.selectCount(new LambdaQueryWrapper<Article>().eq(Article::getDeleted, DeletedEnum.NOT_DELETED.value()));
        vo.setCount(count);
        return vo;
    }
}