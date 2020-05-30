package com.cec.tv.service.impl;

import com.cec.tv.dao.AirPermissionMapper;
import com.cec.tv.model.AirPermission;
import com.cec.tv.service.AirOrganManagerPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirOrganManagerPermissionServiceImpl implements AirOrganManagerPermissionService {


    @Autowired
    AirPermissionMapper mAirPermissionMapper;

    @Override
    public List<AirPermission> queryPermissionById(String id) {
        return mAirPermissionMapper.queryPermissionById(id);
    }
}
