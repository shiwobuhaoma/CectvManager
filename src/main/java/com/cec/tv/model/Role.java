package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@ApiModel("角色实体")
@TableName("userole")
public class Role {
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    @ApiModelProperty(value="id",allowEmptyValue = true,hidden=true)
    private Long id;

    @ApiModelProperty(value="是否能被修改，传False",required = true)
    private Boolean canmodify;


    @ApiModelProperty(value="创建时间",allowEmptyValue = true,required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "createDate")
    private Date createdate;

    @ApiModelProperty(value="是否删除,传False",required = true)
    @TableField(value = "isDel")
    private Boolean isdel;


    @ApiModelProperty(value="角色名称",required =true)
    @TableField(value = "r_name")
    private String rName;

    @ApiModelProperty(value="角色名称",required =true)
    private String role_name;

    @ApiModelProperty(value="角色描述",required =true)
    private String remark;

    @ApiModelProperty(value="角色对应的权限",hidden=true)
    @TableField(exist=false)
    private List<Permission> permissions;//角色权限关系  多对多  一个角色对应多个权限


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCanmodify() {
        return canmodify;
    }

    public void setCanmodify(Boolean canmodify) {
        this.canmodify = canmodify;
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

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}