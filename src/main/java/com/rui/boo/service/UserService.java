package com.rui.boo.service;

import com.rui.boo.domain.User;
import com.rui.boo.message.UserQueryReq;
import com.rui.boo.model.UserModel;
import com.rui.boo.model.UserQueryModel;
import com.rui.boo.shiro.AuthUser;

import java.util.List;

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

    /**
     * 获取总记录数
     * @return
     */
    int getTotalCount();

    /**
     * 分页查询用户信息
     * @param req
     * @return
     */
    List<User> getUserByPage(UserQueryReq req);

    /**
     * 更新或插入用户信息
     * @param model
     * @return
     */
    int updateOrInsertUser(UserModel model);

    /**
     * 用户信息获取
     * @param id
     * @return
     */
    User getUserById(int id);
}
