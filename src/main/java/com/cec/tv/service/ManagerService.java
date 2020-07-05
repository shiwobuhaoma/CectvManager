package com.cec.tv.service;

import com.cec.tv.model.Manage;

import java.util.List;

public interface ManagerService {




    Manage login(String name);


    int logout(String managerId);

    int updateLoginState(Manage manager);

    int insert(Manage manager);

    Manage queryByName(String name);

    Manage queryByToken(String token);

    List<Manage> queryAllOrganList();
}
