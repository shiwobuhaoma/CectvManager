package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("空乘人才报名项目管理员、机构角色")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("air_role")
public class AirRole {
    private String roleId;

    private String roleName;
}