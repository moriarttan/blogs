package ${package.Controller};



import com.example.${package.ModuleName}.dto.${entity}DTO;
import com.example.${package.ModuleName}.vo.${entity}VO;
import com.example.${package.ModuleName}.common.IdForm;
import com.example.${package.ModuleName}.common.Page;
import com.example.${package.ModuleName}.common.PageForm;
import com.example.${package.ModuleName}.common.Result;
import com.example.${package.ModuleName}.service.${entity}Service;
import com.example.${package.ModuleName}.validation.GroupsAdd;
import com.example.${package.ModuleName}.validation.GroupsUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;


/**
* ${table.comment!} 前端控制器
 * @author ${author}
 * @since ${date}
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("v1/back/${table.entityPath}")
<#if swagger>
@Api(value = "API - ${table.controllerName}", tags = "${table.comment!table.controllerName}")
</#if>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${table.entityPath}Service;

    @PreAuthorize("hasAuthority('${table.entityPath}:pageList')")
    @ApiOperation("分页列表")
    @GetMapping("pageList")
    public Result<Page<${entity}VO>> pageList(${entity}DTO dto) {
        return ${table.entityPath}Service.pageList(dto);
    }

    @PreAuthorize("hasAuthority('${table.entityPath}:add')")
    @ApiOperation("新增")
    @PostMapping("add")
    public Result<?> add(@RequestBody @Validated({GroupsAdd.class, Default.class}) ${entity}DTO dto) {
        return ${table.entityPath}Service.add(dto);
    }

    @PreAuthorize("hasAuthority('${table.entityPath}:update')")
    @ApiOperation("修改")
    @PostMapping("update")
    public Result<?> update(@RequestBody @Validated({GroupsUpdate.class, Default.class}) ${entity}DTO dto) {
        return ${table.entityPath}Service.update(dto);
    }

    @ApiOperation("详情")
    @GetMapping("info")
    public Result<${entity}VO> info(@Validated IdForm idForm) {
        return ${table.entityPath}Service.info(idForm.getId());
    }

    @PreAuthorize("hasAuthority('${table.entityPath}:delete')")
    @ApiOperation("删除")
    @PostMapping("delete")
    public Result<?> delete(@RequestBody @Validated IdForm idForm) {
        return ${table.entityPath}Service.delete(idForm.getId());
    }
}


