package com.example.blogs.front.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConfigVo implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 网站名称
     */
    private String name;

    /**
     * 网站英文名称
     */
    private String nameEn;

    /**
     * 网站备案号
     */
    private String recordNumber;

    /**
     * 浏览量统计
     */
    private Integer visitNumber;
}
