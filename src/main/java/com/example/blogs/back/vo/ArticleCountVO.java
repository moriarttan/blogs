package com.example.blogs.back.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 文章统计表
 * @author: Mr言覃
 * @create: 2022-11-01 22:46
 **/
@Data
@TableName("about")
@ApiModel(value = "AboutFrontVO", description = "文章统计")
public class ArticleCountVO {

    @ApiModelProperty("文章总数")
    private Integer count;
}
