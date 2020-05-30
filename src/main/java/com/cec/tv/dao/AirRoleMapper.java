package com.cec.tv.dao;

import com.cec.tv.model.AirRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AirRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(AirRole record);

    int insertSelective(AirRole record);

    AirRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(AirRole record);

    int updateByPrimaryKey(AirRole record);

    List<AirRole> selectRolesById(String roleId);
}