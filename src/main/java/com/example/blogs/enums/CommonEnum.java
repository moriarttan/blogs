package com.example.blogs.enums;


/**
 * 用户状态枚举类
 */
public enum CommonEnum {
    /**禁用*/
    FAIL(0, "禁用"),
    /**启用*/
    ENABLE(1, "启用"),

    /**未删除*/
    NOT_DELETED(0, "未删除"),
    /**已删除*/
    DELETED(1, "已删除"),

    /**未发布*/
    NOT_PUBLISH(0, "未发布"),
    /**已发布*/
    PUBLISH(1, "已发布");

    private Integer value;

    private String msg;

    CommonEnum(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public String message() {
        return msg;
    }

    public Integer value() {
        return value;
    }


    public static String getMsg(Integer value) {
        for (CommonEnum status: CommonEnum.values()) {
            if (status.value().equals(value)) {
                return status.message();
            }
        }
        return null;
    }
}
