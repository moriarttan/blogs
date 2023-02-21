package com.example.blogs.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 言覃
 * @Date: 2022/12/13/23:41
 * @Description: 发送邮箱实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToEmailDTO {
    /**
     * 邮件接收方
     */
    @ApiModelProperty("邮件接收方")
    private String[] tos;
    /**
     * 邮件主题
     */
    @ApiModelProperty("邮件主题")
    private String subject;
    /**
     * 邮件内容
     */
    @ApiModelProperty("邮件内容")
    private String content;
}
