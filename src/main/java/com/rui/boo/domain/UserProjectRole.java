package com.rui.boo.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户-项目-角色 关系
 *
 * @date 2019-01-18 14:41:32
 */
@Data
@NoArgsConstructor
public class UserProjectRole implements Serializable {

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

}