package com.rui.boo.model;

import com.rui.boo.message.PageReq;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户 Model类
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class UserQueryModel extends PageReq implements Serializable {

    /**
     * 姓名
     */
    private String name;
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

}