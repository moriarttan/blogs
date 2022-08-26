package ${package.Service};

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.${package.ModuleName}.dto.${entity}DTO;
import com.example.${package.ModuleName}.vo.${entity}VO;
import com.example.${package.ModuleName}.common.Page;
import com.example.${package.ModuleName}.common.PageForm;
import com.example.${package.ModuleName}.common.Result;
import com.example.${package.ModuleName}.entity.${entity};


/**
* ${table.comment!}  服务类接口
* @author ${author}
* @since ${date}
*/
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 分页列表
    *
    * @param dto 分页列表查询页码页数
    * @return {@link ${entity}VO}
    */
    Result<Page<${entity}VO>> pageList(${entity}DTO dto);


    /**
    * 新增
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> add(${entity}DTO dto);

    /**
    * 修改
    *
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    Result<?> update(${entity}DTO dto);

    /**
    * 详情
    *
    * @param id id
    * @return {@link Result<${entity}VO>}
    */
    Result<${entity}VO> info(Long id);

    /**
    * 删除
    *
    * @param id id
    * @return {@link Result}
    */
    Result<?> delete(Long id);
}