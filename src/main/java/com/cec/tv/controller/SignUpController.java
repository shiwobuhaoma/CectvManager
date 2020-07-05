package com.cec.tv.controller;

import com.cec.tv.model.Students;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.StudentsService;
import com.cec.tv.utils.TextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@Api(tags = "空乘人才报名申请表相关接口")
@RequestMapping("/signUp/")
@RestController
public class SignUpController {
    @Autowired
    private StudentsService studentsService;

    @ApiOperation(value = "提交个人信息接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "commit", method = {RequestMethod.POST})
    public ResponseMessage<String> commit(
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam String name,
            @ApiParam(name = "sex", value = "性别（男，女）", required = true) @RequestParam String sex,
            @ApiParam(name = "age", value = "年龄（24）", required = true) @RequestParam String age,
            @ApiParam(name = "height", value = "身高（176cm）", required = true) @RequestParam String height,
            @ApiParam(name = "mobile", value = "手机号码", required = true) @RequestParam String mobile,
            @ApiParam(name = "organId", value = "机构编号") @RequestParam String organId,
            @ApiParam(name = "isOrgan", value = "是不是机构报名，是传1，不是传0", required = true) @RequestParam String isOrgan){
        ResponseMessage<String> result = new ResponseMessage<>();
        if (TextUtils.isEmpty(name)) {
            result.setFailure("报名人姓名不能为空");
            return result;
        }
        Students students = new Students();
        students.setId(UUID.randomUUID().toString().substring(0,32));
        students.setIsorgansignin(isOrgan);
        students.setName(name);
        students.setSex("男".equals(sex) ? 1 : 0);
        students.setAge(Integer.valueOf(age));
        students.setHeight(Integer.valueOf(height));
        students.setMobile(mobile);
        students.setCreatetime(new Date());
        if (TextUtils.isEmpty(organId)){
            students.setOrganid("1");
        }else{
            students.setOrganid(organId);
        }
        int i = studentsService.commitPersonDetailInformation(students);
        if (i == 0) {
            result.setFailure("提交失败");
        } else {
            result.setSuccess("提交成功");
        }
        return result;
    }
}
