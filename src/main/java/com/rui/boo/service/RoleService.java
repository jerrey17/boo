package com.rui.boo.service;

import java.util.Set;

/**
 * @Author rui
 * @Date 2019-05-21 21:59
 **/
public interface RoleService {

    /**
     * 账户号获取角色编码列表
     * @param userId
     * @return
     */
    Set<String> getRoleCodesByUseId(long userId);
}
