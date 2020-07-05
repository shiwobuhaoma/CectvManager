package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("工作实体")
@TableName("job")
public class Job {
    @ApiModelProperty(value="入职时间",required = true)
    private Date starttime;
    @ApiModelProperty(value="离职时间",required = true)
    private Date endtime;
    @ApiModelProperty(value="公司名称",required = true)
    private String companyname;
    @ApiModelProperty(value="职务",required = true)
    private String post;
    @ApiModelProperty(value="身份证号",required = true)
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

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}