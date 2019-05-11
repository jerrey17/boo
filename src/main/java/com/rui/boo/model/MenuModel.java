package com.rui.boo.model;

import com.rui.boo.domain.Menu;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单 Model类
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class MenuModel implements Serializable {

    /**
     * ID
     */
    private Integer id;
    /**
     * 菜单id
     */
    private Long menuId;
    /**
     * 父id
     */
    private Long parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 访问路径
     */
    private String path;
    /**
     * 菜单类型；1：目录；2：菜单；3：按钮
     */
    private Integer menuType;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;
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

    public MenuModel(Menu domain) {
        this.id = domain.getId();
        this.menuId = domain.getMenuId();
        this.parentId = domain.getParentId();
        this.name = domain.getName();
        this.path = domain.getPath();
        this.menuType = domain.getMenuType();
        this.icon = domain.getIcon();
        this.sort = domain.getSort();
        this.delFlag = domain.getDelFlag();
        this.createTime = domain.getCreateTime();
        this.updateTime = domain.getUpdateTime();
    }

    public static Menu convertDomain(MenuModel model) {
        Menu domain = new Menu();
        domain.setId(model.getId());
        domain.setMenuId(model.getMenuId());
        domain.setParentId(model.getParentId());
        domain.setName(model.getName());
        domain.setPath(model.getPath());
        domain.setMenuType(model.getMenuType());
        domain.setIcon(model.getIcon());
        domain.setSort(model.getSort());
        domain.setDelFlag(model.getDelFlag());
        domain.setCreateTime(model.getCreateTime());
        domain.setUpdateTime(model.getUpdateTime());
        return domain;
    }

}