package com.cec.tv.controller;
import java.text.ParseException;
import	java.text.SimpleDateFormat;
import	java.text.DateFormat;
import com.cec.tv.model.Person;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Api(tags = "空乘人才报名申请表相关接口")
@RequestMapping("/air/")
@RestController
public class AirController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "提交个人信息接口",httpMethod="POST")
    @ResponseBody
    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public ResponseMessage<String> commitPersonDetailInformation(@RequestParam String id,@RequestParam String name,@RequestParam String sex,
                                                                 @RequestParam String age,@RequestParam String height,@RequestParam String weight,
                                                                 @RequestParam String birthday,@RequestParam String mobile,@RequestParam String major,
                                                                 @RequestParam String wx,@RequestParam String email,@RequestParam String postaladdress,
                                                                 @RequestParam String residentialaddress,@RequestParam String remark,
                                                                 @RequestParam String specialty,@RequestParam String location,@RequestParam String lefteye,
                                                                 @RequestParam String righteye,@RequestParam String graduateschool,
                                                                 @RequestParam String graduationtime,@RequestParam String educationlevel,
                                                                 @RequestParam String englishlevel, @RequestParam String airinterview,
                                                                 @RequestParam String whichlink,@RequestParam String levelofeducation){

            ResponseMessage<String> result = new ResponseMessage<>();
            Person person = new Person();
            person.setId(id);
            person.setName(name);
            person.setSex("男".equals(sex)?1:0);
            person.setAge(Integer.valueOf(age));
            person.setHeight(Integer.valueOf(height));
            person.setWeight(Double.valueOf(weight));
            try {
                DateFormat dateFormat = new SimpleDateFormat("YYYY:mm:dd");
                Date birthDate = dateFormat.parse(birthday);
                Date graduationDate = dateFormat.parse(graduationtime);
                person.setBirthday(birthDate);
                person.setBirthday(graduationDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            person.setMobile(mobile);
            person.setMajor(major);
            person.setWx(wx);
            person.setEmail(email);
            person.setPostaladdress(postaladdress);
            person.setResidentialaddress(residentialaddress);
            person.setRemark(remark);
            person.setSpecialty(specialty);
            person.setLocation(location);
            person.setLefteye(Double.valueOf(lefteye));
            person.setRighteye(Double.valueOf(righteye));
            person.setGraduateschool(graduateschool);
            person.setEducationlevel(educationlevel);
            person.setEnglishlevel(englishlevel);
            person.setAirinterview(airinterview);
            person.setWhichlink(whichlink);
            person.setLevelofeducation(levelofeducation);

            int i = personService.commitPersonDetailInformation(person);
            if (i == 0){
                result.setFailure("提交失败");
            }else{
                result.setSuccess("提交成功");
            }
            return result;
    }
}
