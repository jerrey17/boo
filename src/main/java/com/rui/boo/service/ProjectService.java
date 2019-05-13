package com.rui.boo.service;

import com.rui.boo.domain.Project;

import java.util.List;

/**
 * @Author rui
 * @Date 2019-05-12 22:56
 **/
public interface ProjectService {

    /**
     * 获取项目列表，用户id作为查询条件
     * @param userId
     * @return
     */
    List<Project> getProjectByUserId(Long userId);
}
