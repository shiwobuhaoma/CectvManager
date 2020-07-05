package com.cec.tv.dao;

import com.cec.tv.model.Manage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManageMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Manage record);

    int updateLoginState(Manage manager);

    int updateByPrimaryKey(Manage record);

    Manage query(String name);

    Manage queryByToken(String token);

    List<Manage> queryAllOrganList();
}