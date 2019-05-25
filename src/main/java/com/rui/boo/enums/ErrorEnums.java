package com.rui.boo.enums;

import com.rui.boo.message.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author rui
 * @Date 2019-05-23 23:18
 **/
@Getter
@AllArgsConstructor
public enum ErrorEnums implements Message {

    SYS_ERROR("000000", "系统异常"),

    PROJECT_NOT_EXIT("100001", "项目不存在"),

    ;

    private String code;

    private String desc;


    @Override
    public String getErrorCode() {
        return code;
    }

    @Override
    public String getErrorDesc() {
        return desc;
    }}
