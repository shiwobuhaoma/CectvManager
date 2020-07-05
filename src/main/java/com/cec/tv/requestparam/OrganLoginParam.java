package com.cec.tv.requestparam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class OrganLoginParam implements Serializable {
    @ApiModelProperty(value = "机构账号",required = true)
    private String name;
    @ApiModelProperty(value = "机构密码",required = true)
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
