package com.cec.tv.controller;

import com.cec.tv.model.Role;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
@Api(tags = "角色相关接口", description = "提供角色相关的API")
@RestController
@RequestMapping("/role/")
public class RoleController {

    @Autowired
    RoleService roleService;
    @ApiOperation(value = "获取角色列表接口",httpMethod="POST")
    @ResponseBody
//    @RequiresAuthentication
//    @RequiresRoles(value = {"admin","publisher"}, logical = Logical.OR)
    @RequestMapping("getRoleList")
    public ResponseMessage<Set<Role>> getRoleList() {
        ResponseMessage<Set<Role>> responseMessage = new ResponseMessage<>();

        Set<Role> roleList = roleService.getRoleList();
        if (roleList != null) {
            responseMessage.setData(roleList);
            responseMessage.setSuccess("获取角色列表成功");
        }else{
            responseMessage.setSuccess("获取角色列表失败");
        }
        return responseMessage;
    }

    @ApiOperation(value = "增加角色接口",httpMethod="POST")
    @Transactional
    @ResponseBody
//    @RequiresPermissions("admin:all")
//    @RequiresRoles("admin")
    @RequestMapping("addRole")
    public ResponseMessage<String> addRole(@RequestBody Role role) {
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        if (role != null) {
            int i = roleService.addRole(role);
            if (i > 0) {
                responseMessage.setSuccess("增加角色成功");
            } else {
                responseMessage.setFailure("增加角色失败");
            }
        } else {
            responseMessage.setFailure("参数为空");
        }
        return responseMessage;
    }
    @ApiOperation(value = "删除角色接口",httpMethod="POST")
    @Transactional
    @ResponseBody
//    @RequiresPermissions("admin:all")
//    @RequiresRoles("admin")
    @RequestMapping("deleteRole")
    public ResponseMessage<String> deleteRole(@RequestBody Role role) {
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        if (role != null) {
            int i = roleService.deleteRole(role);
            if (i > 0) {
                responseMessage.setSuccess("删除角色成功");
            } else {
                responseMessage.setFailure("删除角色失败");
            }
        } else {
            responseMessage.setFailure("参数为空");
        }
        return responseMessage;
    }
}
