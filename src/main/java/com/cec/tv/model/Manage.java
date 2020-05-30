package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel("空乘人才报名项目管理员、机构")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("air_manage")
public class Manage {
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private String id;

    @ApiModelProperty(value="机构登录账号",required=true)
    private String name;
    @ApiModelProperty(value="机构登录密码",required=true)
    private String password;
    @ApiModelProperty(value="机构权限id",required=true)
    private String permissionid;
    @ApiModelProperty(value="机构角色id",required=true)
    private String roleid;
    @ApiModelProperty(value="登录状态，1登录状态，0未登录状态",required=true)
    private String islogin;
    @ApiModelProperty(value="创建时间",required=true)
    private Date createtime;



}