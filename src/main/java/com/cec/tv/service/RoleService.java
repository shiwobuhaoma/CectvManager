package com.cec.tv.service;

import com.cec.tv.model.Role;

import java.util.Set;

public interface RoleService {
    int addRole(Role role);

    int deleteRole(Role role);

    Set<Role> getRoleList();
}
