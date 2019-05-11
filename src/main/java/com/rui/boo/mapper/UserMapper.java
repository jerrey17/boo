package com.rui.boo.mapper;

import com.rui.boo.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 Mapper接口
 *
 * @date 2019-01-18 14:41:32
 */
@Mapper
public interface UserMapper {

    int insert(@Param("domain") User domain);

    int insertList(@Param("domains") List<User> domains);

    int update(@Param("domain") User domain);

    List<User> select(@Param("domain") User domain);

    User selectOne(@Param("domain") User domain);

}