package com.rui.boo.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class User implements Serializable {

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

    public User(int id) {
        this.id = id;
    }

}