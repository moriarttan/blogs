package com.example.blogs.enums;


/**
 * 用户状态枚举类
 */
public enum DeletedEnum {
    /**禁用*/
    NOT_DELETED(0, "未删除"),
    /**启用*/
    DELETED(1, "已删除");

    private Integer value;

    private String msg;

    DeletedEnum(Integer value, String msg) {
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
        for (DeletedEnum status: DeletedEnum.values()) {
            if (status.value().equals(value)) {
                return status.message();
            }
        }
        return null;
    }
}
