package com.rui.boo.model;

import com.rui.boo.domain.Project;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目 Model类
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class ProjectModel implements Serializable {

    /**
     * ID
     */
    private Integer id;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
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

    public ProjectModel(Project domain) {
        this.id = domain.getId();
        this.projectId = domain.getProjectId();
        this.name = domain.getName();
        this.remark = domain.getRemark();
        this.delFlag = domain.getDelFlag();
        this.createTime = domain.getCreateTime();
        this.updateTime = domain.getUpdateTime();
    }

    public static Project convertDomain(ProjectModel model) {
        Project domain = new Project();
        domain.setId(model.getId());
        domain.setProjectId(model.getProjectId());
        domain.setName(model.getName());
        domain.setRemark(model.getRemark());
        domain.setDelFlag(model.getDelFlag());
        domain.setCreateTime(model.getCreateTime());
        domain.setUpdateTime(model.getUpdateTime());
        return domain;
    }

}