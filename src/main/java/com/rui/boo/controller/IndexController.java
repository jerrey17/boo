package com.rui.boo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
//@Slf4j
@Controller
public class IndexController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(IndexController.class);

    @GetMapping(path = "/index")
    public String index() {

        return "index";
    }

    @GetMapping(path = "/home")
    public String home() {
        log.info("info日志测试");
        log.debug("debug日志测试");
        log.warn("warn日志测试");
        log.error("error日志测试");
        return "home";
    }

    @GetMapping(path = "/main")
    public String main() {

        return "main";
    }
}
