package com.rui.boo.mapper;

import com.rui.boo.domain.UserProjectRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户-项目-角色 关系 Mapper接口
 *
 * @date 2019-01-18 14:41:32
 */
@Repository
@Mapper
public interface UserProjectRoleMapper {

    int insert(@Param("domain") UserProjectRole domain);

    int insertList(@Param("domains") List<UserProjectRole> domains);

    int update(@Param("domain") UserProjectRole domain);

    List<UserProjectRole> select(@Param("domain") UserProjectRole domain);

    UserProjectRole selectOne(@Param("domain") UserProjectRole domain);

}