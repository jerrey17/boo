package com.rui.boo.model;

import com.rui.boo.domain.UserProjectRole;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户-项目-角色 关系 Model类
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class UserProjectRoleModel implements Serializable {

    /**
     * ID
     */
    private Integer id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 默认标识：0：不是默认；1：默认项目
     */
    private Integer defaultFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public UserProjectRoleModel(UserProjectRole domain) {
        this.id = domain.getId();
        this.userId = domain.getUserId();
        this.projectId = domain.getProjectId();
        this.roleId = domain.getRoleId();
        this.defaultFlag = domain.getDefaultFlag();
        this.createTime = domain.getCreateTime();
        this.updateTime = domain.getUpdateTime();
    }

    public static UserProjectRole convertDomain(UserProjectRoleModel model) {
        UserProjectRole domain = new UserProjectRole();
        domain.setId(model.getId());
        domain.setUserId(model.getUserId());
        domain.setProjectId(model.getProjectId());
        domain.setRoleId(model.getRoleId());
        domain.setDefaultFlag(model.getDefaultFlag());
        domain.setCreateTime(model.getCreateTime());
        domain.setUpdateTime(model.getUpdateTime());
        return domain;
    }

}