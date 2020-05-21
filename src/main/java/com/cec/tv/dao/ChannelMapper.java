package com.cec.tv.dao;

import com.cec.tv.model.Channel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ChannelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    List<Channel> getChannelList();
}