package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@ApiModel("工作实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}