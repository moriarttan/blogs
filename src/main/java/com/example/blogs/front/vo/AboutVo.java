package com.example.blogs.front.vo;

import lombok.Data;

@Data
public class AboutVo {
    private Integer id;
    private String title;
    private String content;
    private Integer likeNumber;
    private Integer visitNumber;
    private Integer sizeNumber;
    private Integer isLike;
    private Integer isComment;
}
