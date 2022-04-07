package com.example.blogs.domain;

public class Article {
    private Integer id;

    private String title;

    private Integer likeNumber;

    private Integer visitNumber;

    private Integer sizeNumber;

    private Byte isLike;

    private Byte isComment;

    private Byte status;

    private Byte isDeleted;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }

    public Integer getSizeNumber() {
        return sizeNumber;
    }

    public void setSizeNumber(Integer sizeNumber) {
        this.sizeNumber = sizeNumber;
    }

    public Byte getIsLike() {
        return isLike;
    }

    public void setIsLike(Byte isLike) {
        this.isLike = isLike;
    }

    public Byte getIsComment() {
        return isComment;
    }

    public void setIsComment(Byte isComment) {
        this.isComment = isComment;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", likeNumber=").append(likeNumber);
        sb.append(", visitNumber=").append(visitNumber);
        sb.append(", sizeNumber=").append(sizeNumber);
        sb.append(", isLike=").append(isLike);
        sb.append(", isComment=").append(isComment);
        sb.append(", status=").append(status);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}