package com.rui.boo.mapper;

import com.rui.boo.domain.Project;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 项目 Mapper接口
 *
 * @date 2019-01-18 14:41:32
 */
@Mapper
public interface ProjectMapper {

    int insert(@Param("domain") Project domain);

    int insertList(@Param("domains") List<Project> domains);

    int update(@Param("domain") Project domain);

    List<Project> select(@Param("domain") Project domain);

    Project selectOne(@Param("domain") Project domain);

}