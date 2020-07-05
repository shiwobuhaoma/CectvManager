package com.cec.tv.service.impl;

import com.cec.tv.dao.ManageMapper;
import com.cec.tv.model.Manage;
import com.cec.tv.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManageMapper manageMapper;

    @Override
    public Manage login(String name) {
        return manageMapper.query(name);
    }

    @Override
    public int logout(String managerId) {
        return 0;
    }

    @Override
    public int updateLoginState(Manage manager) {
        return manageMapper.updateLoginState(manager);
    }

    @Override
    public int insert(Manage manager) {
        return manageMapper.insertSelective(manager);
    }

    @Override
    public Manage queryByName(String name) {
        return manageMapper.query(name);
    }

    @Override
    public Manage queryByToken(String token) {
        return manageMapper.queryByToken(token);
    }

    @Override
    public List<Manage> queryAllOrganList() {
        return manageMapper.queryAllOrganList();
    }
}
