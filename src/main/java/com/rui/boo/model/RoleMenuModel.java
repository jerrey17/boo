package com.rui.boo.model;

import com.rui.boo.domain.RoleMenu;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色-菜单 关系 Model类
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class RoleMenuModel implements Serializable {

    /**
     * 用户
     */
    private Integer id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 菜单id
     */
    private Long menuId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public RoleMenuModel(RoleMenu domain) {
        this.id = domain.getId();
        this.roleId = domain.getRoleId();
        this.menuId = domain.getMenuId();
        this.createTime = domain.getCreateTime();
        this.updateTime = domain.getUpdateTime();
    }

    public static RoleMenu convertDomain(RoleMenuModel model) {
        RoleMenu domain = new RoleMenu();
        domain.setId(model.getId());
        domain.setRoleId(model.getRoleId());
        domain.setMenuId(model.getMenuId());
        domain.setCreateTime(model.getCreateTime());
        domain.setUpdateTime(model.getUpdateTime());
        return domain;
    }

}