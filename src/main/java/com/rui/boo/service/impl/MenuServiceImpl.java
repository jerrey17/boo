package com.rui.boo.service.impl;

import com.rui.boo.domain.Menu;
import com.rui.boo.exception.BizException;
import com.rui.boo.mapper.MenuMapper;
import com.rui.boo.model.MenuTreeModel;
import com.rui.boo.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 菜单
 * @Author rui
 * @Date 2019-05-11 22:20
 **/
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuTreeModel> getMenuTree(Long userId, Long projectId) {

        List<Menu> parents = menuMapper.selectParentMenusByUserAndProject(userId, projectId);

        if(Objects.isNull(parents)) {
            throw new BizException("没有配置菜单");
        }

        final List<MenuTreeModel> treeModels = new ArrayList<>();

        parents.stream().forEach(data -> {
            List<Menu> menus = menuMapper.selectMenuByParentId(data.getMenuId());
            if(Objects.nonNull(menus) && menus.size() > 0) {
                treeModels.add(MenuTreeModel.builder().parent(data).menus(menus).build());
            }
        });

        return treeModels;
    }

    @Override
    public Set<String> getPermsByUserId(long userId) {
        List<Menu> menus = menuMapper.selectMenusByUserId(userId);
        return menus.stream().map(data -> data.getPath()).collect(Collectors.toSet());
    }
}
