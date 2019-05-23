package com.rui.boo.mapper;

import com.rui.boo.domain.Menu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 菜单 Mapper接口
 *
 * @date 2019-01-18 14:41:32
 */
@Repository
@Mapper
public interface MenuMapper {

    int insert(@Param("domain") Menu domain);

    int insertList(@Param("domains") List<Menu> domains);

    int update(@Param("domain") Menu domain);

    List<Menu> select(@Param("domain") Menu domain);

    Menu selectOne(@Param("domain") Menu domain);

    List<Menu> selectParentMenusByUserAndProject(@Param("userId") Long userId, @Param("projectId") Long projectId);

    List<Menu> selectMenuByParentId(@Param("parentId") Long parentId);

    List<Menu> selectMenusByUserId(@Param("userId") Long userId);

}