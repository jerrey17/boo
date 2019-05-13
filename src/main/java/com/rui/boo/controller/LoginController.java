package com.rui.boo.controller;

import com.rui.boo.domain.Project;
import com.rui.boo.model.MenuTreeModel;
import com.rui.boo.service.MenuService;
import com.rui.boo.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author rui
 * @Date 2019-01-16 14:26
 **/
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private ProjectService projectService;

    /**
     * login
     * @return
     */
    @GetMapping(path = "/login")
    public String login(Model model) {

        // todo set login param setting

        Long userId = 10000L;

        List<Project> projects = projectService.getProjectByUserId(userId);

        model.addAttribute("projects", projects);

        return "index";
    }

}
