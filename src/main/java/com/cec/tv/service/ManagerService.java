package com.cec.tv.service;

import com.cec.tv.model.Manage;

public interface ManagerService {




    Manage login(String name);


    int logout(String managerId);

    int updateLoginState(Manage manager);

    int insert(Manage manager);

    Manage queryByName(String name);
}
