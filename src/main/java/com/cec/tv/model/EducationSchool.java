package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("毕业学校实体")
@TableName("education")
public class EducationSchool {
    @ApiModelProperty(value = "入学时间", required = true)
    private Date starttime;
    @ApiModelProperty(value = "毕业时间", required = true)
    private Date endtime;
    @ApiModelProperty(value = "学校名字", required = true)
    private String shoolname;
    @ApiModelProperty(value = "专业", required = true)
    private String major;
    @ApiModelProperty(value = "身份证号", required = true)
    private String id;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getShoolname() {
        return shoolname;
    }

    public void setShoolname(String shoolname) {
        this.shoolname = shoolname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}