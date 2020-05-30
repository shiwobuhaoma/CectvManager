package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("空乘人才报名项目管理员、机构权限")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("air_permission")
public class AirPermission {
    private String permissionname;

    private String permissionid;
}