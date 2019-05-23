package com.rui.boo.service.impl;

import com.rui.boo.domain.Role;
import com.rui.boo.mapper.RoleMapper;
import com.rui.boo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author rui
 * @Date 2019-05-21 22:00
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> getRoleCodesByUseId(long userId) {
        List<Role> roles = roleMapper.selectByUserId(userId);
        return roles.stream().map(data -> data.getCode()).collect(Collectors.toSet());
    }
}
