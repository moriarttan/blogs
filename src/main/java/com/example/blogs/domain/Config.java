package com.example.blogs.domain;

public class Config {
    /* id */
    private Integer id;

    /* 网站名称 */
    private String name;

    /* 网站英文名称 */
    private String nameEn;

    /* 网站备案号 */
    private String recordNumber;

    /* 浏览量统计 */
    private Integer visitNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Integer getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }
}