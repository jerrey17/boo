package com.rui.boo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author rui
 * @Date 2019-05-20 22:04
 **/
@Getter
@AllArgsConstructor
public enum UserStatusEnum {

    COMMON(1, "正常"),
    INVALID(0, "禁用")
    ;

    private int code;

    private String msg;



}
