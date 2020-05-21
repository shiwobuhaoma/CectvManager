package com.cec.tv.service;

import com.cec.tv.model.User;

public interface UserService {
    User findUserByName(String username);

    int register(User user);

    User login(String name);


    int updateLoginStatus(User user);
}
