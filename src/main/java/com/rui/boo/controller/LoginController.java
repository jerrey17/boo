package com.rui.boo.controller;

import com.rui.boo.exception.BizException;
import com.rui.boo.message.LoginReq;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author rui
 * @Date 2019-01-16 14:26
 **/
@Slf4j
@Controller
public class LoginController {

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
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(req.getUsername(), req.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (AuthenticationException e) {
            String message;
            if(e instanceof IncorrectCredentialsException) {
                message = "密码错误";
            } else {
                message = e.getMessage();
            }
            model.addAttribute("message", message);
            return "login";
        } catch (Exception e) {
            throw e;
        }
        return "redirect:/index";
    }

}
