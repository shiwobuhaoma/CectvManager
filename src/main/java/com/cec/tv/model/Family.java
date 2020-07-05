package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("家庭信息")
@TableName("family")
public class Family {
    @ApiModelProperty(value="父亲名字",required = true)
    private String fathername;
    @ApiModelProperty(value="母亲名字",required = true)
    private String mathername;
    @ApiModelProperty(value="兄弟名字")
    private String brothername;
    @ApiModelProperty(value="姐妹名字")
    private String sisthername;
    @ApiModelProperty(value="父亲工作",required = true)
    private String fatherjob;
    @ApiModelProperty(value="母亲工作",required = true)
    private String matherjob;
    @ApiModelProperty(value="父亲职务")
    private String fatherpost;
    @ApiModelProperty(value="母亲职务")
    private String motherpost;
    @ApiModelProperty(value="父亲手机号",required = true)
    private String fatherphone;
    @ApiModelProperty(value="母亲手机号",required = true)
    private String motherphone;
    @ApiModelProperty(value="报名人的身份证号",required = true)
    private String id;
    @ApiModelProperty(value="家庭成员",hidden = true)
    private List<Students> familyMember;

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMathername() {
        return mathername;
    }

    public void setMathername(String mathername) {
        this.mathername = mathername;
    }

    public String getBrothername() {
        return brothername;
    }

    public void setBrothername(String brothername) {
        this.brothername = brothername;
    }

    public String getSisthername() {
        return sisthername;
    }

    public void setSisthername(String sisthername) {
        this.sisthername = sisthername;
    }

    public String getFatherjob() {
        return fatherjob;
    }

    public void setFatherjob(String fatherjob) {
        this.fatherjob = fatherjob;
    }

    public String getMatherjob() {
        return matherjob;
    }

    public void setMatherjob(String matherjob) {
        this.matherjob = matherjob;
    }

    public String getFatherpost() {
        return fatherpost;
    }

    public void setFatherpost(String fatherpost) {
        this.fatherpost = fatherpost;
    }

    public String getMotherpost() {
        return motherpost;
    }

    public void setMotherpost(String motherpost) {
        this.motherpost = motherpost;
    }

    public String getFatherphone() {
        return fatherphone;
    }

    public void setFatherphone(String fatherphone) {
        this.fatherphone = fatherphone;
    }

    public String getMotherphone() {
        return motherphone;
    }

    public void setMotherphone(String motherphone) {
        this.motherphone = motherphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Students> getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(List<Students> familyMember) {
        this.familyMember = familyMember;
    }
}