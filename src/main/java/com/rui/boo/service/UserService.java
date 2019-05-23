package com.rui.boo.service;

import com.rui.boo.domain.User;
import com.rui.boo.shiro.AuthUser;

/**
 * @Author rui
 * @Date 2019-05-21 21:32
 **/
public interface UserService {

    /**
     * 账户获取用户信息
     * @param acc
     * @return
     */
    User getUserByAcc(String acc);

    /**
     * 账户号获取认证用户信息
     * @param acc
     * @return
     */
    AuthUser getAuthUserByAcc(String acc);
}
