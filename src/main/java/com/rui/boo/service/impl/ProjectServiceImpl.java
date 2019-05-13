package com.rui.boo.service.impl;

import com.rui.boo.domain.Project;
import com.rui.boo.mapper.ProjectMapper;
import com.rui.boo.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author rui
 * @Date 2019-05-12 22:57
 **/
@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getProjectByUserId(Long userId) {
        return projectMapper.selectByUserId(userId);
    }
}
