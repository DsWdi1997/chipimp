package com.example.chipimp.service.impl;


import com.example.chipimp.dao.UserMapper;
import com.example.chipimp.pojo.User;
import com.example.chipimp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*用户的服务层实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }

    @Override
    public User selectUserById(int user_id) {
        return userMapper.selectUserById(user_id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int user_id) {
        return userMapper.deleteUser(user_id);
    }
}
