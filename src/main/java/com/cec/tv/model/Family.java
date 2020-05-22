package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("家庭信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Person> familyMember;


}