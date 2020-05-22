package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

@ApiModel("人物实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("person")
public class Person {
    @ApiModelProperty(value="身份证",required = true)
    private String id;

    private String name;

    private Integer sex;

    private Integer age;

    private Integer height;

    private Double weight;

    private Date birthday;

    private String mobile;
    @ApiModelProperty(value="专业",required = true)
    private String major;
    @ApiModelProperty(value="微信号",required = true)
    private String wx;

    private String email;
    @ApiModelProperty(value="通讯地址",required = true)
    private String postaladdress;
    @ApiModelProperty(value="现居住地址",required = true)
    private String residentialaddress;
    @ApiModelProperty(value="留言",required = true)
    private String remark;
    @ApiModelProperty(value="特长/奖项",required = true)
    private String specialty;
    @ApiModelProperty(value="户口所在地",required = true)
    private String location;
    @ApiModelProperty(value="户口所在地", hidden = true)
    private String imgpath;
    @ApiModelProperty(value="左眼视力",required = true)
    private Double lefteye;
    @ApiModelProperty(value="右眼视力",required = true)
    private Double righteye;
    @ApiModelProperty(value="毕业学校",required = true)
    private String graduateschool;
    @ApiModelProperty(value="毕业时间",required = true)
    private String graduationtime;
    @ApiModelProperty(value="学历",required = true)
    private String educationlevel;
    @ApiModelProperty(value="英语等级",required = true)
    private String englishlevel;
    @ApiModelProperty(value="是否参加过航空面试，是传1，否传0",required = true)
    private String airinterview;
    @ApiModelProperty(value="参加过航空面试到哪一环节，参加过传字符串，没有参加过传空字符串",required = true)
    private String whichlink;
    @ApiModelProperty(value="文化程度（传字符串：统招，自考，成考，函授）",required = true)
    private String levelofeducation;
    @ApiModelProperty(value="正面照路径", hidden = true)
    private String fullfacephotopath;
    @ApiModelProperty(value="侧身照路径", hidden = true)
    private String sidefacephotopath;
    @ApiModelProperty(value="全身照路径", hidden = true)
    private String fullbodyphotopath;
    @ApiModelProperty(value="1分钟视频路径", hidden = true)
    private String videointroduction;

    @ApiModelProperty(value="工作经历", hidden = true)
    private List<Job> jobList;
    @ApiModelProperty(value="家庭成员", hidden = true)
    private Family family;

}