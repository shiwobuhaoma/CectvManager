package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("空乘人才报名项目管理员、机构")
@TableName("air_manage")
public class Manage implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    @ApiModelProperty(hidden = true)
    private String id;

    @ApiModelProperty(value="机构登录账号",required=true)
    private String name;
    @ApiModelProperty(value="机构登录密码",required=true)
    private String password;
    @ApiModelProperty(value="机构权限id")
    private String permissionid;
    @ApiModelProperty(value="机构角色id")
    private String roleid;
    @ApiModelProperty(value="登录状态，1登录状态，0未登录状态")
    private String islogin;
    @ApiModelProperty(value="创建时间")
    private Date createtime;
    @ApiModelProperty(value="校验登录状态")
    private String token;

    public Manage() {
    }

    public Manage(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getIslogin() {
        return islogin;
    }

    public void setIslogin(String islogin) {
        this.islogin = islogin;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}