package com.rui.boo.service.impl;
import com.rui.boo.enums.UserStatusEnum;

import com.rui.boo.domain.User;
import com.rui.boo.mapper.UserMapper;
import com.rui.boo.service.UserService;
import com.rui.boo.shiro.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author rui
 * @Date 2019-05-21 21:33
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByAcc(String acc) {
        return userMapper.selectByAcc(acc);
    }

    @Override
    public AuthUser getAuthUserByAcc(String acc) {

        User user = this.getUserByAcc(acc);

        if(user == null) {
            return null;
        }

        AuthUser authUser = new AuthUser();
        authUser.setUserId(user.getUserId());
        authUser.setAccount(user.getAccount());
        authUser.setPassword(user.getPassword());
        authUser.setUserStatus(UserStatusEnum.getByCode(user.getUserStatus()));

        return authUser;
    }


}
