
package com.example.usermanagement.mapper;

import com.example.usermanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 查询全部用户
    List<User> selectAll();

    // 根据 ID 查询
    User selectById(@Param("id") Integer id);

    // 新增用户
    int insert(User user);

    // 修改用户
    int update(User user);

    // 删除用户
    int deleteById(@Param("id") Integer id);
}
