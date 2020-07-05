package com.cec.tv.dao;

import com.cec.tv.model.Students;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentsMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(Students record);

    Students selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    List<Students> selectByOrganId( Map<String,Object> map);

    List<Students> queryStudentsOrderByEndTime(Map<String,Object> map);

    List<Students> queryStudentsOrderByStartTime(Map<String,Object> map);

    List<Students> queryStudentsOrderByStartAndEndTime(Map<String,Object> map);

    int queryTotalCountByOrganId(String id);

    List<Students> queryAllByStartAndEndTime(Map<String, Object> map);
}