package com.cec.tv.service;

import com.cec.tv.model.AirPermission;

import java.util.List;

public interface AirOrganManagerPermissionService {

   List<AirPermission> queryPermissionById(String id);

}
