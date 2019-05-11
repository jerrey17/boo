package com.rui.boo.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色-菜单 关系
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class RoleMenu implements Serializable {

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

}