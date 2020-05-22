package com.cec.tv.controller;
import java.text.ParseException;
import	java.text.SimpleDateFormat;
import	java.text.DateFormat;
import com.cec.tv.model.Person;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    public ResponseMessage<String> commitPersonDetailInformation(
            @ApiParam(name="id",value="身份证号",required=true) @RequestParam String id,
            @ApiParam(name="name",value="姓名",required=true)@RequestParam String name,
            @ApiParam(name="sex",value="性别（男，女）",required=true)@RequestParam String sex,
            @ApiParam(name="age",value="年龄（24）",required=true)@RequestParam String age,
            @ApiParam(name="height",value="身高（176cm）",required=true)@RequestParam String height,
            @ApiParam(name="weight",value="体重（53kg）",required=true)@RequestParam String weight,
            @ApiParam(name="birthday",value="生日（YYYY:mm:dd）",required=true)@RequestParam String birthday,
            @ApiParam(name="mobile",value="手机号码",required=true) @RequestParam String mobile,
            @ApiParam(name="major",value="专业",required=true)@RequestParam String major,
            @ApiParam(name="wx",value="微信号",required=true)@RequestParam String wx,
            @ApiParam(name="email",value="邮箱（xxx@xxx.com）",required=true)@RequestParam String email,
            @ApiParam(name="postaladdress",value="通讯地址",required=true) @RequestParam String postaladdress,
            @ApiParam(name="residentialaddress",value="现居住地",required=true)  @RequestParam String residentialaddress,
            @ApiParam(name="remark",value="留言",required=true)  @RequestParam String remark,
            @ApiParam(name="specialty",value="特长/奖项",required=true)  @RequestParam String specialty,
            @ApiParam(name="location",value="户籍所在地",required=true)  @RequestParam String location,
            @ApiParam(name="lefteye",value="左眼视力",required=true)   @RequestParam String lefteye,
            @ApiParam(name="righteye",value="右眼视力",required=true)   @RequestParam String righteye,
            @ApiParam(name="graduateschool",value="毕业学校",required=true)  @RequestParam String graduateschool,
            @ApiParam(name="graduationtime",value="毕业时间（YYYY:mm:dd）",required=true)  @RequestParam String graduationtime,
            @ApiParam(name="educationlevel",value="文化水平（大专、本科、硕士）",required=true)  @RequestParam String educationlevel,
            @ApiParam(name="englishlevel",value="英语等级（B级，A级，4级，雅思...）",required=true)  @RequestParam String englishlevel,
            @ApiParam(name="airinterview",value="是否参加过航空面试，是传1，否传0",required=true)  @RequestParam String airinterview,
            @ApiParam(name="whichlink",value="航空面试到哪一环节")  @RequestParam String whichlink,
            @ApiParam(name="levelofeducation",value="文化程度（统招，自考，成考，函授）",required=true)  @RequestParam String levelofeducation){

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
