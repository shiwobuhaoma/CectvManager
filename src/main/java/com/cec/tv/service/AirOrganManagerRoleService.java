package com.cec.tv.service;

import com.cec.tv.model.AirRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface AirOrganManagerRoleService {

    List<AirRole> selectByPrimaryKey(String roleId);


}