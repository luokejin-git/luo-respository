
package com.example.usermanagement.service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.mapper.UserMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 查询全部用户
    public List<User> getUsers() {
        return userMapper.selectAll();
    }

    // 根据 ID 查询
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    // 新增用户
    @Transactional
    public User addUser(User user) {

        user.setId(null);
        user.setStatus(1);

        userMapper.insert(user);

        return user;
    }

    // 修改用户
    @Transactional
    public User updateUser(Integer id, User data) {

        User existing = userMapper.selectById(id);

        if (existing == null) {
            return null;
        }

        existing.setName(data.getName());
        existing.setAge(data.getAge());
        existing.setEmail(data.getEmail());

        userMapper.update(existing);

        return existing;
    }

    // 删除用户
    @Transactional
    public boolean deleteUser(Integer id) {

        int rows = userMapper.deleteById(id);

        return rows > 0;
    }
}
