package com.example.blogs.service.about;

import com.example.blogs.common.Page;
import com.example.blogs.common.Result;
import com.example.blogs.domain.About;
import com.example.blogs.v1.back.dto.AboutSearchDTO;
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
    * @Description: 新增
    * @Param: 
    * @return: 
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<?> exAdd();
    
    /**
    * @Description: 编辑
    * @Param: 
    * @return: 
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<?> exUpdate();
    
    /**
    * @Description: 详情
    * @Param: 
    * @return: 
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<?> exInfo();
    
    /**
    * @Description: 删除
    * @Param: 
    * @return: 
    * @Author: Mr.Tan
    * @Date: 2022/6/2
    */
    Result<?> exDelete();
}
