package com.cec.tv.service.impl;

import com.cec.tv.dao.ChannelMapper;
import com.cec.tv.model.Channel;
import com.cec.tv.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    ChannelMapper channelMapper;
    @Override
    public List<Channel> getChannelList() {
        return channelMapper.getChannelList();
    }

    @Override
    public int insertNewChannel(Channel channel) {
        return channelMapper.insert(channel);
    }

    @Override
    public int deleteChannel(String channelId) {
        return channelMapper.deleteByPrimaryKey(Long.parseLong(channelId));
    }
}
