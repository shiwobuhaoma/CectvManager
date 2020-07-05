package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("空乘人才报名项目学生实体")
@TableName("person")
public class Students {
    @ApiModelProperty(value="学生id",required = true)
    private String id;
    @ApiModelProperty(value="学生姓名",required = true)
    private String name;
    @ApiModelProperty(value="性别，1是男，0是女",required = true)
    private Integer sex;
    @ApiModelProperty(value="年龄",required = true)
    private Integer age;
    @ApiModelProperty(value="身高",required = true)
    private Integer height;
    @ApiModelProperty(value="手机号码",required = true)
    private String mobile;
    @ApiModelProperty(value="各种照片和1分钟视频存放的路径",required = true)
    private String imgpath;
    @ApiModelProperty(value="是否是机构帮忙报名")
    private String isorgansignin;
    @ApiModelProperty(value="机构的id")
    private String organid;

    @ApiModelProperty(value="正面照路径")
    private String fullfacephotopath;
    @ApiModelProperty(value="侧身照路径")
    private String sidefacephotopath;
    @ApiModelProperty(value="全身照路径")
    private String fullbodyphotopath;
    @ApiModelProperty(value="1分钟视频路径")
    private String videointroduction;
    @ApiModelProperty(value="体重", hidden = true)
    private Double weight;
    @ApiModelProperty(value="生日", hidden = true)
    private Date birthday;
    @ApiModelProperty(value="专业", hidden = true)
    private String major;
    @ApiModelProperty(value="微信号", hidden = true)
    private String wx;
    @ApiModelProperty(value="邮箱", hidden = true)
    private String email;
    @ApiModelProperty(value="通讯地址", hidden = true)
    private String postaladdress;
    @ApiModelProperty(value="现居住地址", hidden = true)
    private String residentialaddress;
    @ApiModelProperty(value="留言", hidden = true)
    private String remark;
    @ApiModelProperty(value="特长/奖项", hidden = true)
    private String specialty;
    @ApiModelProperty(value="户口所在地", hidden = true)
    private String location;
    @ApiModelProperty(value="左眼视力", hidden = true)
    private Double lefteye;
    @ApiModelProperty(value="右眼视力", hidden = true)
    private Double righteye;
    @ApiModelProperty(value="毕业学校", hidden = true)
    private String graduateschool;
    @ApiModelProperty(value="毕业时间", hidden = true)
    private String graduationtime;
    @ApiModelProperty(value="学历", hidden = true)
    private String educationlevel;
    @ApiModelProperty(value="英语等级", hidden = true)
    private String englishlevel;
    @ApiModelProperty(value="是否参加过航空面试，是传1，否传0", hidden = true)
    private String airinterview;
    @ApiModelProperty(value="参加过航空面试到哪一环节，参加过传字符串，没有参加过传空字符串", hidden = true)
    private String whichlink;
    @ApiModelProperty(value="文化程度（传字符串：统招，自考，成考，函授）", hidden = true)
    private String levelofeducation;
    @ApiModelProperty(value="报名时间")
    private Date createtime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getIsorgansignin() {
        return isorgansignin;
    }

    public void setIsorgansignin(String isorgansignin) {
        this.isorgansignin = isorgansignin;
    }

    public String getOrganid() {
        return organid;
    }

    public void setOrganid(String organid) {
        this.organid = organid;
    }

    public String getFullfacephotopath() {
        return fullfacephotopath;
    }

    public void setFullfacephotopath(String fullfacephotopath) {
        this.fullfacephotopath = fullfacephotopath;
    }

    public String getSidefacephotopath() {
        return sidefacephotopath;
    }

    public void setSidefacephotopath(String sidefacephotopath) {
        this.sidefacephotopath = sidefacephotopath;
    }

    public String getFullbodyphotopath() {
        return fullbodyphotopath;
    }

    public void setFullbodyphotopath(String fullbodyphotopath) {
        this.fullbodyphotopath = fullbodyphotopath;
    }

    public String getVideointroduction() {
        return videointroduction;
    }

    public void setVideointroduction(String videointroduction) {
        this.videointroduction = videointroduction;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(String postaladdress) {
        this.postaladdress = postaladdress;
    }

    public String getResidentialaddress() {
        return residentialaddress;
    }

    public void setResidentialaddress(String residentialaddress) {
        this.residentialaddress = residentialaddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLefteye() {
        return lefteye;
    }

    public void setLefteye(Double lefteye) {
        this.lefteye = lefteye;
    }

    public Double getRighteye() {
        return righteye;
    }

    public void setRighteye(Double righteye) {
        this.righteye = righteye;
    }

    public String getGraduateschool() {
        return graduateschool;
    }

    public void setGraduateschool(String graduateschool) {
        this.graduateschool = graduateschool;
    }

    public String getGraduationtime() {
        return graduationtime;
    }

    public void setGraduationtime(String graduationtime) {
        this.graduationtime = graduationtime;
    }

    public String getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }

    public String getEnglishlevel() {
        return englishlevel;
    }

    public void setEnglishlevel(String englishlevel) {
        this.englishlevel = englishlevel;
    }

    public String getAirinterview() {
        return airinterview;
    }

    public void setAirinterview(String airinterview) {
        this.airinterview = airinterview;
    }

    public String getWhichlink() {
        return whichlink;
    }

    public void setWhichlink(String whichlink) {
        this.whichlink = whichlink;
    }

    public String getLevelofeducation() {
        return levelofeducation;
    }

    public void setLevelofeducation(String levelofeducation) {
        this.levelofeducation = levelofeducation;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}