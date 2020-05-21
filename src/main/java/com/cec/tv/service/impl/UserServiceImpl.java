package com.cec.tv.service.impl;

import com.cec.tv.dao.UserMapper;
import com.cec.tv.model.User;
import com.cec.tv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Transactional
    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }

    public User login(String userName) {
        return userMapper.login(userName);
    }

    @Transactional
    @Override
    public int updateLoginStatus(User user) {
        return userMapper.updateLoginStatus(user);
    }
}
