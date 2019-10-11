package com.rui.boo.service.impl;
import com.alibaba.druid.support.json.JSONUtils;
import com.rui.boo.enums.DelFlagEnum;
import com.rui.boo.enums.UserStatusEnum;

import com.rui.boo.domain.User;
import com.rui.boo.mapper.UserMapper;
import com.rui.boo.message.PageReq;
import com.rui.boo.message.UserQueryReq;
import com.rui.boo.model.UserModel;
import com.rui.boo.model.UserQueryModel;
import com.rui.boo.service.UserService;
import com.rui.boo.shiro.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.NumberUtils;

import java.util.List;
import java.util.Objects;

/**
 * @Author rui
 * @Date 2019-05-21 21:33
 **/
@Slf4j
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

    @Override
    public int getTotalCount() {
        return userMapper.selectCount();
    }

    @Override
    public List<User> getUserByPage(UserQueryReq req) {

        UserQueryModel model = new UserQueryModel();
        BeanUtils.copyProperties(req, model);

        return userMapper.selectByPage(model);
    }

    @Override
    public int updateOrInsertUser(UserModel model) {
        if(Objects.isNull(model.getId())) {
            // add
            log.info("新增用户-请求参数:{}", JSONUtils.toJSONString(model));
            // model.setUserId(); // TODO 提供分布式id生成器
            model.setPassword("000000"); // 初始化密码为六个0
            model.setUserStatus(UserStatusEnum.COMMON.getCode());
            model.setDelFlag(DelFlagEnum.COMMON.getCode());

            User user = new User();
            BeanUtils.copyProperties(model, user);
            int count = userMapper.insert(user);
            if(count == 1) {
                log.info("新增用户-成功-记录:{}", count);
            }
            return count;

        } else {
            // update
            log.info("用户更新-请求参数:{}", JSONUtils.toJSONString(model));
            User user = new User();
            BeanUtils.copyProperties(model, user);
            int count = userMapper.update(user);
            if(count == 1) {
                log.info("用户更新-成功-记录:{}", count);
            }
            return count;

        }
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectOne(new User(id));
    }


}
