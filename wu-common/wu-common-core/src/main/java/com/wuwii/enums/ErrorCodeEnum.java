package com.wuwii.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by KronChan on 2018/4/27 15:05.
 */
@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    /**
     * SYS
     */
    SYS_400(400, "请求错误"),
    SYS_401(401, "登陆失败，请重新登陆。"),
    SYS_403(403, "没有权限，请联系管理员"),
    SYS_500(500, "服务器内部错误"),

    /**
     * ADMIN
     */
    ADMIN_100001(100001, "验证码错误，请重新输入"),
    ;


    private int code;

    private String msg;
}
