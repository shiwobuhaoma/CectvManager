package com.cec.tv.requestparam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class OrganLogoutParam implements Serializable {
    @ApiModelProperty(value = "机构编号",required = true)
   private String managerId;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
