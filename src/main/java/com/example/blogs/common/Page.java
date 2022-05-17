package com.example.blogs.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/* 分页返回参数
* */
@Data
public class Page<T> {
//    @ApiModelProperty(value = "第几页")
    private Integer pageNum;

//    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

//    @ApiModelProperty(value = "页总数")
    private Integer totalPage;

//    @ApiModelProperty(value = "数据总数")
    private Long total;

//    @ApiModelProperty(value = "获得数据数量")
    private Integer totalSize;

//    @ApiModelProperty(value = "获得数据")
    private List<T> rows;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> Page<T> toPage(List<T> list) {
        Page<T> result = new Page<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setTotalSize(pageInfo.getSize());
        result.setRows(pageInfo.getList());
        return result;
    }

}
