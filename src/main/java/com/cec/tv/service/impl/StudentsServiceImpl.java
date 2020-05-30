package com.cec.tv.service.impl;
import	java.util.HashMap;

import com.cec.tv.dao.StudentsMapper;
import com.cec.tv.model.Students;
import com.cec.tv.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StudentsServiceImpl implements StudentsService {


    @Autowired
    StudentsMapper studentsMapper;
    @Override
    public int commitPersonDetailInformation(Students students) {

       System.out.println(students.toString());
        return studentsMapper.insert(students);
    }

    @Override
    public List<Students> queryAll(String managerId) {
        return studentsMapper.selectByOrganId(managerId);
    }

    @Override
    public List<Students> queryStudentsOrderByEndTime(String managerId, Date date) {
        Map<String,Object> map = new HashMap<> ();
        map.put("organid",managerId);
        map.put("createtime",date);
        return studentsMapper.queryStudentsOrderByEndTime(map);
    }

    @Override
    public List<Students> queryStudentsOrderByOnlyStartTime(String managerId, Date startDate) {
        Map<String,Object> map = new HashMap<> ();
        map.put("organid",managerId);
        map.put("createtime",startDate);
        return studentsMapper.queryStudentsOrderByStartTime(map);
    }

    @Override
    public List<Students> queryStudentsOrderByStartAndEndTime(String managerId, Date startDate, Date endDate) {
        Map<String,Object> map = new HashMap<> ();
        map.put("organid",managerId);
        map.put("starttime",managerId);
        map.put("endtime",startDate);
        return studentsMapper.queryStudentsOrderByStartAndEndTime(map);
    }

}
