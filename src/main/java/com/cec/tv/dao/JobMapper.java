package com.cec.tv.dao;

import com.cec.tv.model.Job;

public interface JobMapper {
    int insert(Job record);

    int insertSelective(Job record);
}