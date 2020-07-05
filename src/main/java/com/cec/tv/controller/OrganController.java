package com.cec.tv.controller;

import com.cec.tv.model.Manage;
import com.cec.tv.model.Students;
import com.cec.tv.requestparam.OrganManagerParam;
import com.cec.tv.requestparam.QueryStudentsParam;
import com.cec.tv.respones.StudentsResponse;
import com.cec.tv.result.Pager;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.AirOrganManagerPermissionService;
import com.cec.tv.service.AirOrganManagerRoleService;
import com.cec.tv.service.ManagerService;
import com.cec.tv.service.StudentsService;
import com.cec.tv.utils.DateUtil;
import com.cec.tv.utils.TextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "空乘人才报名项目机构相关接口")
@RequestMapping("/organ/")
@RestController
public class OrganController {

    @Autowired
    AirOrganManagerPermissionService mAirOrganManagerPermissionService;
    @Autowired
    AirOrganManagerRoleService mAirOrganManagerRoleService;
    @Autowired
    ManagerService mManagerService;
    @Autowired
    StudentsService mStudentsService;

    @ApiOperation(value = "分配机构账户接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "addOrganManager", method = {RequestMethod.POST})
    ResponseMessage<String> addOrganManager(@RequestBody OrganManagerParam organManagerParam, HttpServletRequest request) {
        ResponseMessage<String> result = new ResponseMessage<>();
        if (organManagerParam != null){
            if (TextUtils.isEmpty(organManagerParam.getName()) || TextUtils.isEmpty(organManagerParam.getPassword())) {
                result.setFailure("参数不全");
            } else {
                Manage manager = new Manage();
                manager.setName(organManagerParam.getName());
                manager.setId(organManagerParam.getId());
                manager.setPassword(organManagerParam.getPassword());
                //1代表后台管理员，2代表机构
                manager.setRoleid("2");
                manager.setPermissionid("2");
                manager.setIslogin("0");

//            manager.setCreatetime(new Date());
                //给air_manage表增加数据
                int i = mManagerService.insert(manager);
                if (i > 0) {
                    result.setData("成功");
                    result.setToken(request.getSession().getId());
                    result.setSuccess("成功");
                } else {
                    result.setFailure("失败");
                }
            }
        }

        return result;
    }

    @ApiOperation(value = "获取所有机构列表接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "list", method = {RequestMethod.POST})
    ResponseMessage<List<Manage>>  list(HttpServletRequest request) {
        ResponseMessage<List<Manage>> result = new ResponseMessage<>();
        List<Manage> list =  mManagerService.queryAllOrganList();
        list.add(0,new Manage("admin","全部"));
        if (list.size() > 0) {
            result.setData(list);
            result.setToken(request.getSession().getId());
            result.setSuccess("成功");
        } else {
            result.setFailure("失败");
        }

        return result;
    }



    @ApiOperation(value = "机构查询某段时间学生的报名列表接口,需要登录", httpMethod = "POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "organQueryStudentsByTime", method = {RequestMethod.POST})
    ResponseMessage<List<Students>> organQueryStudentsByTime(@RequestBody QueryStudentsParam queryStudentsParam, HttpServletRequest request
    ) {
        ResponseMessage<List<Students>> result = new ResponseMessage<>();
        if (queryStudentsParam != null) {
            if (TextUtils.isEmpty(queryStudentsParam.getOrganId())) {
                result.setFailure("您没有权限");
                return result;
            }
            if ("admin".equals(queryStudentsParam.getOrganId())){
                List<Students> students = mStudentsService.queryAll(DateUtil.convertDateStrToDate(queryStudentsParam.getStartTime(), "date"),DateUtil.convertDateStrToDate(queryStudentsParam.getEndTime(), "date"));
                if (students.size()>0){
                    result.setData(students);
                    result.setSuccess("成功");
                }else{
                    result.setSuccess("没有报名学生信息");
                }
                result.setToken(request.getSession().getId());
                return result;
            }else{
//            StudentsResponse studentsResponse = new StudentsResponse();
                //根据机构ID查询一共有多少条学生报名纪律
//            int totalCount = mStudentsService.queryTotalCountByOrganId(queryStudentsParam.getOrganId());
//            studentsResponse.setTotalCount(totalCount);
//            String pageIndex = queryStudentsParam.getPageIndex();
//            String pageSize = queryStudentsParam.getPageSize();
//
//            int pages = totalCount / Integer.parseInt(pageSize);
//            if (totalCount % Integer.parseInt(pageSize) > 0){
//                pages++;
//            }
//            studentsResponse.setPagesCount(pages);

                //如果起始时间没有，
//            Pager<Students>
                List<Students>  students = null;
                if (TextUtils.isEmpty(queryStudentsParam.getStartTime())) {


                    //如果结束时间也没有，
                    if (TextUtils.isEmpty(queryStudentsParam.getEndTime())) {
                        //默认查找某个机构下所有报名的学生信息
                        students = mStudentsService.queryAll(queryStudentsParam.getOrganId());//,pageSize,pageIndex
//                    studentsResponse.setList(students);
                    } else {
                        //如果结束时间有值，查询结束时间之前报名的所有学生信息
                        Date date = DateUtil.convertDateStrToDate(queryStudentsParam.getEndTime(), "date");
                        students = mStudentsService.queryStudentsOrderByEndTime(queryStudentsParam.getOrganId(), date);//,pageSize,pageIndex
//                    studentsResponse.setList(students);
                    }
                    result.setSuccess("成功");
                    result.setToken(request.getSession().getId());
                    result.setData(students);
                    return result;
                } else {
                    //如果有起始时间，并且结束时间没有，就是查询起始时间到当前日期之间报名的所有学生信息
                    Date startDate = DateUtil.convertDateStrToDate(queryStudentsParam.getStartTime(), "date");
                    if (TextUtils.isEmpty(queryStudentsParam.getEndTime())) {

//                Date endDate = DateUtil.getCurrTime();
                        students = mStudentsService.queryStudentsOrderByOnlyStartTime(queryStudentsParam.getOrganId(), startDate);//,pageSize,pageIndex
//                    studentsResponse.setList(students);
                    } else {
                        //如果有起始时间，并且结束时间也有值，就是查询起始时间到结束时间之间报名的所有学生信息
                        Date endDate = DateUtil.convertDateStrToDate(queryStudentsParam.getEndTime(), "date");
                        students = mStudentsService.queryStudentsOrderByStartAndEndTime(queryStudentsParam.getOrganId(), startDate, endDate);//,pageSize,pageIndex
//                    studentsResponse.setList(students);
                    }
                    result.setSuccess("成功");
                    result.setData(students);

                }
            }


        } else {
            result.setFailure("参数为空");
        }
        return result;
    }


//    @ApiOperation(value = "根据机构ID查询机构的角色接口,需要登录", httpMethod = "POST")
//    @Transactional
//    @ResponseBody
//    @RequestMapping(value = "queryRole", method = {RequestMethod.POST})
//    ResponseMessage<List<AirRole>> queryAirOrganManagerRole(
//            @ApiParam(name = "organId", value = "机构id", required = true) @RequestParam String organId) {
//        ResponseMessage<List<AirRole>> result = new ResponseMessage<>();
//        if (organId == null || "".equals(organId)) {
//            result.setFailure("organId为空");
//            result.setData(new ArrayList<>());
//
//        } else {
//            List<AirRole> airPermissions = mAirOrganManagerRoleService.selectByPrimaryKey(organId);
//            if (airPermissions != null && airPermissions.size() > 0) {
//                result.setSuccess("成功");
//                result.setData(airPermissions);
//            } else {
//                result.setFailure("没有配置角色，请联系管理员");
//                result.setData(new ArrayList<>());
//            }
//        }
//        return result;
//    }
}
