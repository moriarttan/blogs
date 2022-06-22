package com.example.blogs.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author 15755
 */
@Data
public class About {

    private Integer id;

    private String title;

    private String content;

    private Integer likeNumber;

    private Integer visitNumber;

    private Integer sizeNumber;

    private Integer isLike;

    private Integer isComment;

    private Date createTime;

    private Date updateTime;
}