package com.rui.boo.model;

import com.rui.boo.domain.User;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户 Model类
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class UserModel implements Serializable {

    /**
     * ID
     */
    private Integer id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 账户
     */
    private String account;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户状态：1：正常；0：禁用
     */
    private Integer userStatus;
    /**
     * 删除标识：1：未删除；0：已删除
     */
    private Integer delFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public UserModel(User domain) {
        this.id = domain.getId();
        this.userId = domain.getUserId();
        this.name = domain.getName();
        this.password = domain.getPassword();
        this.account = domain.getAccount();
        this.email = domain.getEmail();
        this.userStatus = domain.getUserStatus();
        this.delFlag = domain.getDelFlag();
        this.createTime = domain.getCreateTime();
        this.updateTime = domain.getUpdateTime();
    }

    public static User convertDomain(UserModel model) {
        User domain = new User();
        domain.setId(model.getId());
        domain.setUserId(model.getUserId());
        domain.setName(model.getName());
        domain.setPassword(model.getPassword());
        domain.setAccount(model.getAccount());
        domain.setEmail(model.getEmail());
        domain.setUserStatus(model.getUserStatus());
        domain.setDelFlag(model.getDelFlag());
        domain.setCreateTime(model.getCreateTime());
        domain.setUpdateTime(model.getUpdateTime());
        return domain;
    }

}