package com.cec.tv.service;

import com.cec.tv.model.Students;

import java.util.Date;
import java.util.List;

public interface StudentsService {
    int commitPersonDetailInformation(Students students);

    List<Students> queryAll(String managerId);

    List<Students> queryStudentsOrderByEndTime(String managerId, Date endDate);

    List<Students> queryStudentsOrderByOnlyStartTime(String managerId, Date startDate);

    List<Students> queryStudentsOrderByStartAndEndTime(String managerId, Date startDate, Date endDate);
}
