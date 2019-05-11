package com.rui.boo.mapper;

import com.rui.boo.domain.RoleMenu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 角色-菜单 关系 Mapper接口
 *
 * @date 2019-01-18 14:41:32
 */
@Mapper
public interface RoleMenuMapper {

    int insert(@Param("domain") RoleMenu domain);

    int insertList(@Param("domains") List<RoleMenu> domains);

    int update(@Param("domain") RoleMenu domain);

    List<RoleMenu> select(@Param("domain") RoleMenu domain);

    RoleMenu selectOne(@Param("domain") RoleMenu domain);

}