package ${package.Mapper};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.${package.ModuleName}.dto.${entity}DTO;
import com.example.${package.ModuleName}.vo.${entity}VO;
import com.example.${package.ModuleName}.entity.${entity};
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* ${table.comment!}  Mapper 接口
* @author ${author}
* @since ${date}
*/
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    /**
    * 分页列表
    *
    * @param dto 搜索参数
    * @return {@link List<${entity}VO>}
    */
    List<${entity}VO> pageList(@Param("dto") ${entity}DTO dto);
}