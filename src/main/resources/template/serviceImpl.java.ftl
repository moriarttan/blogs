package ${package.ServiceImpl};

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.example.${package.ModuleName}.dto.${entity}DTO;
import com.example.${package.ModuleName}.vo.${entity}VO;
import com.example.${package.ModuleName}.common.Page;
import com.example.${package.ModuleName}.common.PageForm;
import com.example.${package.ModuleName}.common.Result;
import com.example.${package.ModuleName}.entity.${entity};
import com.example.${package.ModuleName}.mapper.${entity}Mapper;
import com.example.${package.ModuleName}.service.${entity}Service;
import com.example.${package.ModuleName}.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ${table.comment!} 服务实现类
* @author ${author}
* @since ${date}
*/
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
    * 分页列表
    * @param dto 分页列表查询页码页数
    * @return {@link ${entity}VO}
    */
    @Override
    public Result<Page<${entity}VO>> pageList(${entity}DTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(),"create_time desc");
        return Result.success(Page.toPage(baseMapper.pageList(dto)));
    }

    /**
    * 新增
    * @param dto 新增/修改参数
    * @return {@link Result}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> add(${entity}DTO dto) {
    ${entity} ${table.entityPath} = CopyUtil.transfer(dto, ${entity}.class);
        int tag = baseMapper.insert(${table.entityPath});
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
    public Result<?> update(${entity}DTO dto) {
    ${entity} ${table.entityPath} = CopyUtil.transfer(dto, ${entity}.class);
        int tag = baseMapper.updateById(${table.entityPath});
        if(0 == tag){
            return Result.failed("修改操作失败");
        }
        return Result.success();
    }

    /**
    * 详情
    * @param id id
    * @return {@link Result<${entity}VO>}
    */
    @Override
    public Result<${entity}VO> info(Long id) {
        ${entity} ${table.entityPath} = baseMapper.selectById(id);
        return Result.success(CopyUtil.transfer(${table.entityPath}, ${entity}VO.class));
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
}