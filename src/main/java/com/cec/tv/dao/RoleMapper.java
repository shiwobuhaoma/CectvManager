package com.cec.tv.dao;

import com.cec.tv.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int deleteRole(Role record);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Set<String> queryRolesByUserName(String name);

    Set<Role> getRoleList();

}