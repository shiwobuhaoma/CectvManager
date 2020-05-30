package com.cec.tv.service.impl;

import com.cec.tv.dao.AirRoleMapper;
import com.cec.tv.model.AirRole;
import com.cec.tv.service.AirOrganManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirOrganManagerRoleServiceImpl implements AirOrganManagerRoleService {
    @Autowired
    AirRoleMapper mAirRoleMapper;
    @Override
    public List<AirRole> selectByPrimaryKey(String roleId) {
        return mAirRoleMapper.selectRolesById(roleId);
    }
}
