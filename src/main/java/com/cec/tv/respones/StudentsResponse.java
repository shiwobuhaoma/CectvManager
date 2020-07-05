package com.cec.tv.respones;

import com.cec.tv.model.Students;
import com.cec.tv.result.Pager;

import java.io.Serializable;
import java.util.List;

public class StudentsResponse implements Serializable {

    private int totalCount;
    private int pagesCount;
    private Pager<Students> list;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public void setList(Pager<Students> list) {
        this.list = list;
    }
}
