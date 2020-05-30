package com.cec.tv.dao;

import com.cec.tv.model.Students;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    List<Students> selectByOrganId(String managerId);

    List<Students> queryStudentsOrderByEndTime(Map<String,Object> map);

    List<Students> queryStudentsOrderByStartTime(Map<String,Object> map);

    List<Students> queryStudentsOrderByStartAndEndTime(Map<String,Object> map);
}