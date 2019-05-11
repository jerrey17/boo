package com.rui.boo.model;

import com.rui.boo.domain.Role;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色 Model类
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class RoleModel implements Serializable {

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

    public RoleModel(Role domain) {
        this.id = domain.getId();
        this.roleId = domain.getRoleId();
        this.name = domain.getName();
        this.code = domain.getCode();
        this.remark = domain.getRemark();
        this.createUser = domain.getCreateUser();
        this.updateUser = domain.getUpdateUser();
        this.delFlag = domain.getDelFlag();
        this.createTime = domain.getCreateTime();
        this.updateTime = domain.getUpdateTime();
    }

    public static Role convertDomain(RoleModel model) {
        Role domain = new Role();
        domain.setId(model.getId());
        domain.setRoleId(model.getRoleId());
        domain.setName(model.getName());
        domain.setCode(model.getCode());
        domain.setRemark(model.getRemark());
        domain.setCreateUser(model.getCreateUser());
        domain.setUpdateUser(model.getUpdateUser());
        domain.setDelFlag(model.getDelFlag());
        domain.setCreateTime(model.getCreateTime());
        domain.setUpdateTime(model.getUpdateTime());
        return domain;
    }

}