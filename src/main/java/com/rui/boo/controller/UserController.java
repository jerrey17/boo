package com.rui.boo.controller;

import com.rui.boo.domain.User;
import com.rui.boo.enums.ErrorEnums;
import com.rui.boo.exception.BizException;
import com.rui.boo.message.MessageBean;
import com.rui.boo.message.PageResp;
import com.rui.boo.message.UserQueryReq;
import com.rui.boo.model.UserModel;
import com.rui.boo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author rui
 * @Date 2019-09-30 15:02
 **/
@Slf4j
@Controller
public class UserController extends BasicController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表页面
     *
     * @return
     */
    @GetMapping(path = "/user/page")
    public String userPage() {
        return "user-list";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/update")
    public String userUpdatePage(@PathVariable("id") int id, Model model) {
        log.info("获取用户信息-id:{}", id);
        if (id <= 0) {
            throw new BizException(ErrorEnums.PARAM_ERROR);
        }
        User user = userService.getUserById(id);
        log.info("获取用户信息-查询结果:{}", user);
        model.addAttribute("user", user);
        return "user-add";
    }

    /**
     * 用户列表查询
     *
     * @param request
     * @return
     */
    @GetMapping("/user/list")
    @ResponseBody
    public PageResp<User> getUserList(UserQueryReq request) {
        log.info("查询用户列表-入参:{}", request);
        return this.pageSupplier(
                () -> userService.getTotalCount(),
                () -> userService.getUserByPage(request)
        );
    }

    /**
     * 保存用户信息
     *
     * @param model
     * @return
     */
    @PostMapping("/user/save")
    @ResponseBody
    public MessageBean<Integer> saveOrUpdateUser(@RequestBody UserModel model) {
        log.info("保存用户信息-入参:{}", model);
        return this.supplier(() -> {
            // todo 参数验证
            return userService.updateOrInsertUser(model);
        });
    }

}
