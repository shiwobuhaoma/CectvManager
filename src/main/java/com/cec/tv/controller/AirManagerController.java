package com.cec.tv.controller;

import com.cec.tv.model.AirPermission;
import com.cec.tv.model.AirRole;
import com.cec.tv.model.Manage;
import com.cec.tv.model.Students;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.AirOrganManagerPermissionService;
import com.cec.tv.service.AirOrganManagerRoleService;
import com.cec.tv.service.ManagerService;
import com.cec.tv.service.StudentsService;
import com.cec.tv.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "空乘人才报名项目管理员、机构相关接口", description = "提供修改权限或者角色相关的API")
@RequestMapping("/manager/")
@RestController
public class AirManagerController {

    @Autowired
    AirOrganManagerPermissionService mAirOrganManagerPermissionService;
    @Autowired
    AirOrganManagerRoleService mAirOrganManagerRoleService;
    @Autowired
    ManagerService mManagerService;
    @Autowired
    StudentsService mStudentsService;

    @ApiOperation(value = "根据机构ID查询机构的权限接口", httpMethod = "POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "queryPermission", method = {RequestMethod.POST})
    ResponseMessage<List<AirPermission>> queryAirOrganManagerPermission(
            @ApiParam(name="organId",value="机构id",required=true) @RequestParam String organId) {
        ResponseMessage<List<AirPermission>> result = new ResponseMessage<>();
        if (organId == null || "".equals(organId)) {
            result.setFailure("organId为空");
            result.setData(new ArrayList<>());

        } else {
            List<AirPermission> airPermissions = mAirOrganManagerPermissionService.queryPermissionById(organId);
            if (airPermissions != null && airPermissions.size() > 0) {
                result.setSuccess("成功");
                result.setData(airPermissions);
            } else {
                result.setFailure("没有配置权限，请联系管理员");
                result.setData(new ArrayList<>());
            }
        }
        return result;
    }


    @ApiOperation(value = "给机构分配账号接口,此接口已经分配好角色和权限", httpMethod = "POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "insertAirOrganManager", method = {RequestMethod.POST})
    ResponseMessage<String> insertAirOrganManager(
            @ApiParam(name="manager",value="机构实体",required=true) @RequestBody Manage manager) {
        ResponseMessage<String> result = new ResponseMessage<>();
        if (manager == null) {
            result.setFailure("参数不全");
        } else {
            //给air_manage表增加数据
            int i = mManagerService.insert(manager);
            if (i > 0) {
                result.setSuccess("成功");
            } else {
                result.setFailure("失败");
            }
        }
        return result;
    }


    @ApiOperation(value = "机构查询某段时间学生的报名列表接口", httpMethod = "POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "organQueryStudentsByTime", method = {RequestMethod.POST})
    ResponseMessage<List<Students>> organQueryStudentsByTime(
            @ApiParam(name="managerId",value="机构id",required=true) @RequestParam String managerId,
            @ApiParam(name="startTime",value="开始时间",required=true) @RequestParam String startTime,
            @ApiParam(name="endTime",value="结束时间",required=true) @RequestParam String endTime) {
        ResponseMessage<List<Students>> result = new ResponseMessage<>();
        if (managerId == null || "".equals(managerId)) {
            result.setFailure("managerId为空");
            result.setData(new ArrayList<>());
        }
        //如果起始时间没有，
        List<Students> students = null;
        if (startTime == null || "".equals(startTime) ) {
            //如果结束时间也没有，
            if (endTime == null || "".equals(endTime)){
                //默认查找某个机构下所有报名的学生信息
                students = mStudentsService.queryAll(managerId);
            }else{
                //如果结束时间有值，查询结束时间之前报名的所有学生信息
                Date date = DateUtil.convertDateStrToDate(endTime, "date");

                students = mStudentsService.queryStudentsOrderByEndTime(managerId,date);
            }
            result.setSuccess("成功");
            result.setData(students);
            return result;
        }else{
            //如果有起始时间，并且结束时间没有，就是查询起始时间到当前日期之间报名的所有学生信息
            Date startDate = DateUtil.convertDateStrToDate(startTime, "date");
            if (endTime == null || "".equals(endTime)){

                Date endDate = DateUtil.getCurrTime();
                students = mStudentsService.queryStudentsOrderByOnlyStartTime(managerId,startDate);
            }else{
                //如果有起始时间，并且结束时间也有值，就是查询起始时间到结束时间之间报名的所有学生信息
                Date endDate = DateUtil.convertDateStrToDate(endTime, "date");
                students = mStudentsService.queryStudentsOrderByStartAndEndTime(managerId,startDate,endDate);
            }
            result.setSuccess("成功");
            result.setData(students);
            return result;
        }
    }


    @ApiOperation(value = "根据机构ID查询机构的角色接口", httpMethod = "POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "queryRole", method = {RequestMethod.POST})
    ResponseMessage<List<AirRole>> queryAirOrganManagerRole(
            @ApiParam(name="organId",value="机构id",required=true) @RequestParam String organId) {
        ResponseMessage<List<AirRole>> result = new ResponseMessage<>();
        if (organId == null || "".equals(organId)) {
            result.setFailure("organId为空");
            result.setData(new ArrayList<>());

        } else {
            List<AirRole> airPermissions = mAirOrganManagerRoleService.selectByPrimaryKey(organId);
            if (airPermissions != null && airPermissions.size() > 0) {
                result.setSuccess("成功");
                result.setData(airPermissions);
            } else {
                result.setFailure("没有配置角色，请联系管理员");
                result.setData(new ArrayList<>());
            }
        }
        return result;
    }
}
