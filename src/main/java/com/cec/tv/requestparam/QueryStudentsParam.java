package com.cec.tv.requestparam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class QueryStudentsParam implements Serializable {

    @ApiModelProperty(value = "机构id",required = true)
    private String organId;
    @ApiModelProperty(value = "开始时间",required = true)
    private String startTime;
    @ApiModelProperty(value = "结束时间",required = true)
    private String endTime;
//    @ApiModelProperty(value = "一页多少条数据",required = true)
//    private String pageSize;
//    @ApiModelProperty(value = "第几页",required = true)
//    private String pageIndex;

    public String getOrganId() {
        return organId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

//    public String getPageSize() {
//        return pageSize;
//    }
//
//    public String getPageIndex() {
//        return pageIndex;
//    }

    public void setManagerId(String organId) {
        this.organId = organId;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

//    public void setPageSize(String pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public void setPageIndex(String pageIndex) {
//        this.pageIndex = pageIndex;
//    }
}
