package com.rui.boo.controller;

import com.rui.boo.domain.Project;
import com.rui.boo.enums.ErrorEnums;
import com.rui.boo.exception.BizException;
import com.rui.boo.model.MenuTreeModel;
import com.rui.boo.service.MenuService;
import com.rui.boo.service.ProjectService;
import com.rui.boo.shiro.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author rui
 * @Date 2019-01-16 14:26
 **/
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private MenuService menuService;

    /**
     * 项目index
     * @param model
     * @return
     */
    @GetMapping(path = "/index")
    public String index(Model model) {
        AuthUser user = (AuthUser) SecurityUtils.getSubject().getPrincipal();
        List<Project> projects = projectService.getProjectByUserId(user.getUserId());
        model.addAttribute("projects", projects);
        return "index";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping(path = "/home/{parentId}")
    public String home(@PathVariable("parentId") Long parentId, Model model) {
        if(parentId == null) {
            throw new BizException(ErrorEnums.PROJECT_NOT_EXIT);
        }
        AuthUser user = (AuthUser) SecurityUtils.getSubject().getPrincipal();
        long userId = user.getUserId();
        List<MenuTreeModel> menuTreeModels = menuService.getMenuTree(userId, parentId);
        model.addAttribute("menuTree", menuTreeModels);

        log.info("主页[home]-用户[{}-{}]获取菜单列表:{}", userId, parentId, menuTreeModels);
        return "home";
    }

    /**
     * 未授权跳转
     * @return
     */
    @GetMapping(path = "/error/401")
    public Mono<String> p401() {
        return Mono.just("error/401");
    }
}
