package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@ApiModel("毕业学校实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("education")
public class EducationSchool {
    @ApiModelProperty(value="入学时间",required = true)
    private Date starttime;
    @ApiModelProperty(value="毕业时间",required = true)
    private Date endtime;
    @ApiModelProperty(value="学校名字",required = true)
    private String shoolname;
    @ApiModelProperty(value="专业",required = true)
    private String major;
    @ApiModelProperty(value="身份证号",required = true)
    private String id;

}