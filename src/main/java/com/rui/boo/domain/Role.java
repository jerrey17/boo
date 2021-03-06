package com.rui.boo.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class Role implements Serializable {

    /**
     * ID
     */
    private Integer id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建用户
     */
    private String createUser;
    /**
     * 更新用户
     */
    private String updateUser;
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

}