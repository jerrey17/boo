package com.rui.boo.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class Project implements Serializable {

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

}