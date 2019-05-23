package com.rui.boo.controller;

import com.rui.boo.domain.Project;
import com.rui.boo.model.MenuTreeModel;
import com.rui.boo.service.MenuService;
import com.rui.boo.service.ProjectService;
import com.rui.boo.shiro.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(path = "/common/404")
    public Mono<String> p404() {

        return Mono.just("404");
    }

    @GetMapping(path = "/common/500")
    public Mono<String> p500() {

        return Mono.just("500");
    }

    @GetMapping(path = "/common/401")
    public Mono<String> p401() {

        return Mono.just("401");
    }
}
