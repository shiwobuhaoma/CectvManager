package com.cec.tv.service;

import com.cec.tv.model.Students;
import com.cec.tv.result.Pager;

import java.util.Date;
import java.util.List;

public interface StudentsService {
    int commitPersonDetailInformation(Students students);

//    Pager<Students>
    List<Students> queryAll(String managerId);//, String pageSize, String pageIndex

    List<Students> queryAll(Date startDate, Date endDate);

//    Pager<Students>
    List<Students>  queryStudentsOrderByEndTime(String managerId, Date endDate);//,String pageSize,String pageIndex

//    Pager<Students>
    List<Students>  queryStudentsOrderByOnlyStartTime(String managerId, Date startDate);//,String pageSize,String pageIndex

//    Pager<Students>
    List<Students>  queryStudentsOrderByStartAndEndTime(String managerId, Date startDate, Date endDate);//,String pageSize,String pageIndex

    int update(Students student);

    int queryTotalCountByOrganId(String managerId);
}
