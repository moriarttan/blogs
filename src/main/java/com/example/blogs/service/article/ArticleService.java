package com.example.blogs.service.article;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.domain.Article;
import com.example.blogs.domain.Users;
import com.example.blogs.v1.back.dto.AboutSearchDTO;
import com.example.blogs.v1.back.dto.AboutUpdateDTO;
import com.example.blogs.v1.back.dto.ArticleSearchDTO;
import com.example.blogs.v1.back.dto.ArticleUpdateDTO;
import com.example.blogs.v1.back.vo.AboutInfoVO;
import com.example.blogs.v1.back.vo.AboutSearchVO;
import com.example.blogs.v1.back.vo.ArticleInfoVO;
import com.example.blogs.v1.back.vo.ArticleSearchVO;

import java.util.List;

/**
 * 关于我们-服务层
 * @author 15755
 */

public interface ArticleService extends IService<Article> {

    /**
    * @Description: 分页列表
    * @Param: 
    * @return: 
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<Page<ArticleSearchVO>> pageList(ArticleSearchDTO searchDTO);

    /**
    * @Description: 查询列表
    * @Param:
    * @return:
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<List<Article>> queryList();

    /**
     * 添加
     * @param articleUpdateDTO
     * @return
     */
    Result<?> add(ArticleUpdateDTO articleUpdateDTO);

    /**
     * 编辑
     * @param articleUpdateDTO
     * @return
     */
    Result<?> update(ArticleUpdateDTO articleUpdateDTO);

    /**
     * 详情
     * @param id 请求id
     * @return
     */
    Result<ArticleInfoVO> info(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    Result<?> delete(Integer id);
}
