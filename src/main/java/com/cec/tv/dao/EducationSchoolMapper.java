package com.cec.tv.dao;

import com.cec.tv.model.EducationSchool;

public interface EducationSchoolMapper {
    int insert(EducationSchool record);

    int insertSelective(EducationSchool record);
}