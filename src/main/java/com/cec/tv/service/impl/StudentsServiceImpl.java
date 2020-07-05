package com.cec.tv.service.impl;
import	java.util.HashMap;

import com.cec.tv.dao.StudentsMapper;
import com.cec.tv.model.Students;
import com.cec.tv.result.Pager;
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
        return studentsMapper.insertSelective(students);
    }

    //Pager<Students>
    @Override
    public List<Students> queryAll(String managerId) {//, String pageSize, String pageIndex
        Map<String,Object> map = new HashMap<> ();
        map.put("organid",managerId);
//        map.put("pageSize",pageSize);
//        map.put("pageIndex",pageIndex);
        List<Students> students = studentsMapper.selectByOrganId(map);
//        Pager<Students> pager = new Pager<>();
//        pager.setRows(students);
//        pager.setTotal(studentsMapper.queryTotalCountByOrganId(managerId));
        return students;
    }

    @Override
    public List<Students> queryAll(Date startDate, Date endDate) {
        Map<String,Object> map = new HashMap<> ();
        map.put("starttime",startDate);
        map.put("endtime",endDate);
        return studentsMapper.queryAllByStartAndEndTime(map);
    }

    //Pager<Students>
    @Override
    public List<Students> queryStudentsOrderByEndTime(String managerId, Date date) {//,String pageSize,String pageIndex
        Map<String,Object> map = new HashMap<> ();
        map.put("organid",managerId);
        map.put("createtime",date);
//        map.put("pageSize",pageSize);
//        map.put("pageIndex",pageIndex);
        List<Students> students = studentsMapper.queryStudentsOrderByEndTime(map);
//        Pager<Students> pager = new Pager<>();
//        pager.setRows(students);
//        pager.setTotal(studentsMapper.queryTotalCountByOrganId(managerId));
        return students;
    }

    //Pager<Students>
    @Override
    public List<Students> queryStudentsOrderByOnlyStartTime(String managerId, Date startDate) {//,String pageSize,String pageIndex
        Map<String,Object> map = new HashMap<> ();
        map.put("organid",managerId);
        map.put("createtime",startDate);
//        map.put("pageSize",pageSize);
//        map.put("pageIndex",pageIndex);
        List<Students> students =  studentsMapper.queryStudentsOrderByStartTime(map);
//        Pager<Students> pager = new Pager<>();
//        pager.setRows(students);
//        pager.setTotal(studentsMapper.queryTotalCountByOrganId(managerId));
        return students;
    }

    //Pager<Students>
    @Override
    public List<Students> queryStudentsOrderByStartAndEndTime(String managerId, Date startDate, Date endDate) {//,String pageSize,String pageIndex
        Map<String,Object> map = new HashMap<> ();
        map.put("organid",managerId);
        map.put("starttime",startDate);
        map.put("endtime",endDate);
//        map.put("pageSize",pageSize);
//        map.put("pageIndex",pageIndex);
        List<Students> students =  studentsMapper.queryStudentsOrderByStartAndEndTime(map);
//        Pager<Students> pager = new Pager<>();
//        pager.setRows(students);
//        pager.setTotal(studentsMapper.queryTotalCountByOrganId(managerId));
        return students;
    }

    @Override
    public int update(Students student) {
        return studentsMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int queryTotalCountByOrganId(String managerId) {

        return studentsMapper.queryTotalCountByOrganId(managerId);
    }

}
