package com.cec.tv.service.impl;

import com.cec.tv.dao.RoleMapper;
import com.cec.tv.model.Role;
import com.cec.tv.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;


    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int deleteRole(Role role) {
        return roleMapper.deleteRole(role);
    }

    @Override
    public Set<Role> getRoleList() {
        return roleMapper.getRoleList();
    }
}
