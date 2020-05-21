package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@ApiModel("用户实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    @ApiModelProperty(value="id",allowEmptyValue = true,hidden=true)
    private Long id;

    @ApiModelProperty(value="用户名",required=true)
    private String username;

    @ApiModelProperty(value="密码",required=true)
    private String userpwd;

    @ApiModelProperty(value="注册时间",allowEmptyValue = true,hidden=true)
    @TableField(value = "createDate")
    private Date createdate;

    @ApiModelProperty(value="是否注销",hidden=true)
    @TableField(value = "isDel")
    private Boolean isdel;

    @ApiModelProperty(value="备注",hidden=true)
    private String remark;

    @ApiModelProperty(value="角色id",hidden=true)
    @TableField(value = "role_id")
    private Long roleId;

    @ApiModelProperty(value="邮箱地址",hidden=true)
    private String email;

    @ApiModelProperty(value="是否登录标志",hidden=true)
    private Integer islogin;

    @ApiModelProperty(value="用户对应什么角色",hidden=true)
    //用户的角色   一对多关系
    private List<Role> roleList;

}