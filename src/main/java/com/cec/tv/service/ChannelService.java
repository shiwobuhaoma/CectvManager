package com.cec.tv.service;

import com.cec.tv.model.Channel;


import java.util.List;

public interface ChannelService {
    List<Channel> getChannelList();

    int insertNewChannel(Channel channel);

    int deleteChannel(String channelId);
}
