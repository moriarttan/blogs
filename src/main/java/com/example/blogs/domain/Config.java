package com.example.blogs.domain;

public class Config {
    private Integer id;

    private String backAddress;

    private String backName;

    private String backPhone;

    private Integer integrateProportion;

    private Integer boxRefreshCount;

    private Integer boxRefreshNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackAddress() {
        return backAddress;
    }

    public void setBackAddress(String backAddress) {
        this.backAddress = backAddress;
    }

    public String getBackName() {
        return backName;
    }

    public void setBackName(String backName) {
        this.backName = backName;
    }

    public String getBackPhone() {
        return backPhone;
    }

    public void setBackPhone(String backPhone) {
        this.backPhone = backPhone;
    }

    public Integer getIntegrateProportion() {
        return integrateProportion;
    }

    public void setIntegrateProportion(Integer integrateProportion) {
        this.integrateProportion = integrateProportion;
    }

    public Integer getBoxRefreshCount() {
        return boxRefreshCount;
    }

    public void setBoxRefreshCount(Integer boxRefreshCount) {
        this.boxRefreshCount = boxRefreshCount;
    }

    public Integer getBoxRefreshNum() {
        return boxRefreshNum;
    }

    public void setBoxRefreshNum(Integer boxRefreshNum) {
        this.boxRefreshNum = boxRefreshNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", backAddress=").append(backAddress);
        sb.append(", backName=").append(backName);
        sb.append(", backPhone=").append(backPhone);
        sb.append(", integrateProportion=").append(integrateProportion);
        sb.append(", boxRefreshCount=").append(boxRefreshCount);
        sb.append(", boxRefreshNum=").append(boxRefreshNum);
        sb.append("]");
        return sb.toString();
    }
}