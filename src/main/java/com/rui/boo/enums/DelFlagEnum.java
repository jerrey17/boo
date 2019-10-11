package com.rui.boo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author rui
 * @Date 2019-05-20 22:04
 **/
@Getter
@AllArgsConstructor
public enum DelFlagEnum {

    COMMON(1, "正常"),
    DELETED(0, "已删除")
    ;

    private int code;

    private String msg;

    public static DelFlagEnum getByCode(int code) {
        for(DelFlagEnum delFlagEnum : values()) {
            if(delFlagEnum.getCode() == code) {
                return delFlagEnum;
            }
        }
        return null;
    }

}
