package com.rui.boo.controller;

import com.rui.boo.model.MenuTreeModel;
import com.rui.boo.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author rui
 * @Date 2019-05-11 22:59
 **/
@Slf4j
@Controller
public class MenuController {

//    @Autowired
//    private MenuService menuService;
//
//    @GetMapping(path = "/list/{parentId}")
//    public List<MenuTreeModel> getMenuTree(@PathVariable("parentId") Long parentId) {
//        // todo validate param: parentId
//        // todo get userId from session
//        long userId = 10000;
//
//        log.info("用户[{}-{}]获取菜单列表！", userId, parentId);
//
//        List<MenuTreeModel> menuTreeModels = menuService.getMenuTree(userId, parentId);
//
//        return menuTreeModels;
//    }
}
