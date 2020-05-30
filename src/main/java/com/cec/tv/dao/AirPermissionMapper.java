package com.cec.tv.dao;

import com.cec.tv.model.AirPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AirPermissionMapper {
    int insert(AirPermission record);

    int insertSelective(AirPermission record);

    List<AirPermission> queryPermissionById(String id);
}