package com.rui.boo.shiro;

import com.rui.boo.enums.UserStatusEnum;
import lombok.Data;

/**
 * @Author rui
 * @Date 2019-05-20 22:02
 **/
@Data
public class AuthUser {

    private Long userId;

    private String account;

    private String password;

    private UserStatusEnum userStatus;
}
