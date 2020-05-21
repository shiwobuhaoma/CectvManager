package com.cec.tv.dao;

import com.cec.tv.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String userName);

    int updateLoginStatus(User user);

    User findUserByName(String username);

    String getRole(String userName);
}