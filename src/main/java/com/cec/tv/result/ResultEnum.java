package com.cec.tv.result;

public enum ResultEnum {
    UNKNOWN_ERROR(-100, "未知错误"),
    SUCCESS(1, "成功"),
    NOT_PERMISSION(0, "没有权限"),
    NEED_LOGIN(0, "未登录"),
    REPEAT_REGISTER(0, "该用户已注册"),
    USER_NOT_EXIST(0, "不存在该用户"),
    PASSWORD_ERROR(0, "密码错误"),
    EMPTY_USERNAME_OR_PASSWORD(0, "用户名或密码为空"),
    EMPTY_PARAMETER(0, "密码为空"),
    ADD_CATEGORY_SUCCESS(1,"添加成功"),
    ADD_CATEGORY_FAILURE(0,"添加失败"),
    DELETE_CATEGORY_SUCCESS(1,"删除成功"),
    DELETE_CATEGORY_FAILURE(0,"删除失败"),
    SYSTEM_ERROR(-1000001,"系统错误");


    private Integer code;

    private String msg;

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
