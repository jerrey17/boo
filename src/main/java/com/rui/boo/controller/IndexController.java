package com.rui.boo.controller;

import com.rui.boo.model.MenuTreeModel;
import com.rui.boo.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author rui
 * @Date 2019-01-16 14:26
 **/
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @GetMapping(path = "/index")
    public String index() {

        return "index";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping(path = "/home/{parentId}")
    public String home(@PathVariable("parentId") Long parentId, Model model) {

        // todo validate param: parentId
        // todo get userId from session
        long userId = 10000;


        List<MenuTreeModel> menuTreeModels = menuService.getMenuTree(userId, parentId);
        log.info("跳转主页-用户[{}-{}]获取菜单列表:{}", userId, parentId, menuTreeModels);

        model.addAttribute("menuTree", menuTreeModels);

        return "home";
    }

    @GetMapping(path = "/main")
    public String main() {

        return "main";
    }
}
