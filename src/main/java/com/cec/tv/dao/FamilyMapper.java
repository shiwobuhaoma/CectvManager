package com.cec.tv.dao;

import com.cec.tv.model.Family;

public interface FamilyMapper {
    int insert(Family record);

    int insertSelective(Family record);
}