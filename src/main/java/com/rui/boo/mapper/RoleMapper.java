package com.rui.boo.mapper;

import com.rui.boo.domain.Role;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 角色 Mapper接口
 *
 * @date 2019-01-18 14:41:32
 */
@Mapper
public interface RoleMapper {

    int insert(@Param("domain") Role domain);

    int insertList(@Param("domains") List<Role> domains);

    int update(@Param("domain") Role domain);

    List<Role> select(@Param("domain") Role domain);

    Role selectOne(@Param("domain") Role domain);

}