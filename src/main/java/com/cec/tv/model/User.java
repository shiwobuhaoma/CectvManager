package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("用户实体")
@TableName("user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    @ApiModelProperty(value = "id", allowEmptyValue = true, hidden = true)
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String userpwd;

    @ApiModelProperty(value = "注册时间", allowEmptyValue = true, hidden = true)
    @TableField(value = "createDate")
    private Date createdate;

    @ApiModelProperty(value = "是否注销", hidden = true)
    @TableField(value = "isDel")
    private Boolean isdel;

    @ApiModelProperty(value = "备注", hidden = true)
    private String remark;

    @ApiModelProperty(value = "角色id", hidden = true)
    @TableField(value = "role_id")
    private Long roleId;

    @ApiModelProperty(value = "邮箱地址", hidden = true)
    private String email;

    @ApiModelProperty(value = "是否登录标志", hidden = true)
    private Integer islogin;

    @ApiModelProperty(value = "用户对应什么角色", hidden = true)
    //用户的角色   一对多关系
    private List<Role> roleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIslogin() {
        return islogin;
    }

    public void setIslogin(Integer islogin) {
        this.islogin = islogin;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}