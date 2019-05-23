package com.rui.boo.controller;

import com.rui.boo.controller.message.LoginReq;
import com.rui.boo.domain.Project;
import com.rui.boo.service.ProjectService;
import com.rui.boo.shiro.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
     * login page
     * @return
     */
    @GetMapping(path = "/login")
    public String login() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * login
     * @return
     */
    @PostMapping(path = "/login")
    public String login(LoginReq req, Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(req.getUsername(), req.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
//        AuthUser user = (AuthUser) subject.getPrincipal();
//        List<Project> projects = projectService.getProjectByUserId(user.getUserId());
//        model.addAttribute("projects", projects);
        return "redirect:/index";
//        return Mono.just(req).map(data -> {
//        }).onErrorResume(throwable -> {
//            log.error("登录异常!", throwable);
//            return Mono.just("redirect:/login");
//        });
    }

}
