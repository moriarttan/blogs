package com.example.blogs.enums;


/**
 * 用户状态枚举类
 */
public enum UserStatusEnum {
    /**禁用*/
    FAIL(0, "禁用"),
    /**启用*/
    ENABLE(1, "启用");

    private Integer value;

    private String msg;

    UserStatusEnum(Integer value, String msg) {
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
        for (UserStatusEnum status: UserStatusEnum.values()) {
            if (status.value().equals(value)) {
                return status.message();
            }
        }
        return null;
    }
}
