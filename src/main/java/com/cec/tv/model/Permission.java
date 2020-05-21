package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("permission")
public class Permission {
    private Long id;

    private Boolean canmodify;

    private Date createdate;

    private String rtName;

    private String number;

    private String remark;

    private String permission;

    private List<Role> roles;//角色权限关系   多对多
}