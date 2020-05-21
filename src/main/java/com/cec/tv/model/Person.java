package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@ApiModel("人物实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("person")
public class Person {
    private String id;

    private String name;

    private Integer sex;

    private Integer age;

    private Integer height;

    private Double weight;

    private Date birthday;

    private String mobile;

    private String major;

    private String wx;

    private String email;

    private String postaladdress;

    private String residentialaddress;

    private String remark;

    private String specialty;

    private String location;

    private String imgpath;

    private Double lefteye;

    private Double righteye;

    private String graduateschool;

    private String graduationtime;

    private String educationlevel;

    private String englishlevel;

    private String airinterview;

    private String whichlink;

    private String levelofeducation;

    private String fullfacephotopath;

    private String sidefacephotopath;

    private String fullbodyphotopath;

    private String videointroduction;


}