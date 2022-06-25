package com.example.blogs.service.about;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.v1.back.dto.AboutSearchDTO;
import com.example.blogs.v1.back.dto.AboutUpdateDTO;
import com.example.blogs.v1.back.vo.AboutInfoVO;
import com.example.blogs.v1.back.vo.AboutSearchVO;

import java.util.List;

/**
 * 关于我们-服务层
 * @author 15755
 */

public interface AboutService {

    /**
    * @Description: 分页列表
    * @Param: 
    * @return: 
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<Page<AboutSearchVO>> pageList(AboutSearchDTO searchDTO);
    
    /**
    * @Description: 查询列表
    * @Param: 
    * @return: 
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<List<About>> queryList();

    /**
     * 添加
     * @param aboutUpdateDTO
     * @return
     */
    Result<?> add(AboutUpdateDTO aboutUpdateDTO);

    /**
     * 编辑
     * @param aboutUpdateDTO
     * @return
     */
    Result<?> update(AboutUpdateDTO aboutUpdateDTO);

    /**
     * 详情
     * @param id 请求id
     * @return
     */
    Result<AboutInfoVO> info(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    Result<?> delete(Integer id);
}
