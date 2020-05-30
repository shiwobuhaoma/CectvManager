package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@ApiModel("空乘人才报名项目学生实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ApiModelProperty(value="工作经历", hidden = true)
    private List<Job> jobList;
    @ApiModelProperty(value="家庭成员", hidden = true)
    private Family family;

}