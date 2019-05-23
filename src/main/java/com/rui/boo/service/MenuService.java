package com.rui.boo.service;

import com.rui.boo.model.MenuTreeModel;

import java.util.List;
import java.util.Set;

/**
 * @Author rui
 * @Date 2019-05-11 22:19
 **/
public interface MenuService {

    /**
     * 获取菜单树列表
     * @param userId 用户id
     * @param projectId 项目id
     * @return
     */
    List<MenuTreeModel> getMenuTree(Long userId, Long projectId);

    /**
     * 用户id获取菜单权限列表
     * @param userId
     * @return
     */
    Set<String> getPermsByUserId(long userId);
}
