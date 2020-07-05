package com.cec.tv.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import com.cec.tv.model.Students;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.StudentsService;
import com.cec.tv.utils.TextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.UUID;


@Api(tags = "空乘人才报名申请表相关接口")
@RequestMapping("/air/")
@RestController
public class AirController {


    @Autowired
    private StudentsService studentsService;

    @ApiIgnore
    @ApiOperation(value = "提交个人信息接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public ResponseMessage<String> commitPersonDetailInformation(
            @ApiParam(name = "id", value = "身份证号", required = true) @RequestParam String id,
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam String name,
            @ApiParam(name = "sex", value = "性别（男，女）", required = true) @RequestParam String sex,
            @ApiParam(name = "age", value = "年龄（24）", required = true) @RequestParam String age,
            @ApiParam(name = "height", value = "身高（176cm）", required = true) @RequestParam String height,
            @ApiParam(name = "weight", value = "体重（53kg）", required = true) @RequestParam String weight,

            @ApiParam(name = "mobile", value = "手机号码", required = true) @RequestParam String mobile,
            @ApiParam(name = "major", value = "专业", required = true) @RequestParam String major,
            @ApiParam(name = "wx", value = "微信号", required = true) @RequestParam String wx,
            @ApiParam(name = "email", value = "邮箱（xxx@xxx.com）", required = true) @RequestParam String email,
            @ApiParam(name = "postaladdress", value = "通讯地址", required = true) @RequestParam String postaladdress,
            @ApiParam(name = "residentialaddress", value = "现居住地", required = true) @RequestParam String residentialaddress,
            @ApiParam(name = "remark", value = "留言", required = true) @RequestParam String remark,
            @ApiParam(name = "specialty", value = "特长/奖项", required = true) @RequestParam String specialty,
            @ApiParam(name = "location", value = "户籍所在地", required = true) @RequestParam String location,
            @ApiParam(name = "lefteye", value = "左眼视力", required = true) @RequestParam String lefteye,
            @ApiParam(name = "righteye", value = "右眼视力", required = true) @RequestParam String righteye,
            @ApiParam(name = "graduateschool", value = "毕业学校", required = true) @RequestParam String graduateschool,
            @ApiParam(name = "graduationtime", value = "毕业时间（YYYY:mm:dd）", required = true) @RequestParam String graduationtime,
            @ApiParam(name = "educationlevel", value = "文化水平（大专、本科、硕士）", required = true) @RequestParam String educationlevel,
            @ApiParam(name = "englishlevel", value = "英语等级（B级，A级，4级，雅思...）", required = true) @RequestParam String englishlevel,
            @ApiParam(name = "airinterview", value = "是否参加过航空面试，是传1，否传0", required = true) @RequestParam String airinterview,
            @ApiParam(name = "whichlink", value = "航空面试到哪一环节") @RequestParam String whichlink,
            @ApiParam(name = "levelofeducation", value = "文化程度（统招，自考，成考，函授）", required = true) @RequestParam String levelofeducation) {

        ResponseMessage<String> result = new ResponseMessage<>();
        Students students = new Students();
        students.setId(id);
        students.setName(name);
        students.setSex("男".equals(sex) ? 1 : 0);
        students.setAge(Integer.valueOf(age));
        students.setHeight(Integer.valueOf(height));
        students.setWeight(Double.valueOf(weight));
        try {
            DateFormat dateFormat = new SimpleDateFormat("YYYY:mm:dd");
            String birthday = id.substring(6, 10) + ":" + id.substring(10, 12) + ":" + id.substring(12, 14);
            Date birthDate = dateFormat.parse(birthday);
            Date graduationDate = dateFormat.parse(graduationtime);
            students.setBirthday(birthDate);
            students.setBirthday(graduationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        students.setMobile(mobile);
        students.setMajor(major);
        students.setWx(wx);
        students.setEmail(email);
        students.setPostaladdress(postaladdress);
        students.setResidentialaddress(residentialaddress);
        students.setRemark(remark);
        students.setSpecialty(specialty);
        students.setLocation(location);
        students.setLefteye(Double.valueOf(lefteye));
        students.setRighteye(Double.valueOf(righteye));
        students.setGraduateschool(graduateschool);
        students.setEducationlevel(educationlevel);
        students.setEnglishlevel(englishlevel);
        students.setAirinterview(airinterview);
        students.setWhichlink(whichlink);
        students.setLevelofeducation(levelofeducation);

        int i = studentsService.commitPersonDetailInformation(students);
        if (i == 0) {
            result.setFailure("提交失败");
        } else {
            result.setSuccess("提交成功");
        }
        return result;
    }

    @ApiOperation(value = "提交个人信息接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "add2", method = {RequestMethod.POST})
    public ResponseMessage<String> commitPersonSimpleInformation(
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam String name,
            @ApiParam(name = "sex", value = "性别（男，女）", required = true) @RequestParam String sex,
            @ApiParam(name = "age", value = "年龄（24）", required = true) @RequestParam String age,
            @ApiParam(name = "height", value = "身高（176cm）", required = true) @RequestParam String height,
            @ApiParam(name = "mobile", value = "手机号码", required = true) @RequestParam String mobile,
            @ApiParam(name = "isOrgan", value = "是不是机构报名，是传1，不是传0", required = true) @RequestParam String isOrgan
//            @ApiParam(name = "organId", value = "机构代号,不是机构不传") @RequestParam String organId,
//            @ApiParam(name = "fullfacephoto", value = "正面半身照") @RequestParam("fullfacephoto") MultipartFile fullFacePhoto,
//            @ApiParam(name = "sidefacephoto", value = "侧面半身照") @RequestParam("sidefacephoto") MultipartFile sideFacePhoto,
//            @ApiParam(name = "fullbodyphoto", value = "全身照") @RequestParam("fullbodyphoto") MultipartFile fullBodyPhoto,
//            @ApiParam(name = "videointroduction", value = "1分钟视频自我介绍") @RequestParam("videointroduction") MultipartFile videoIntroduction
    ) {

        ResponseMessage<String> result = new ResponseMessage<>();
        Students students = new Students();
        students.setId(UUID.randomUUID().toString());
        if (TextUtils.isEmpty(name)) {
            result.setFailure("报名人姓名不能为空");
            return result;
        }
        students.setName(name);
        students.setIsorgansignin(isOrgan);
//        students.setOrganid(organId);
        students.setName(name);
        students.setSex("男".equals(sex) ? 1 : 0);
        students.setAge(Integer.valueOf(age));
        students.setHeight(Integer.valueOf(height));
        students.setMobile(mobile);

        String type = "";

//        if (big2M(fullFacePhoto)) {
//            result.setFailure("正面半身照大小不能超过2M");
//            return result;
//        }else{
//            type= "fullfacephoto";
//            boolean writeSuccess = writeFile2Location(fullFacePhoto, name, mobile, students,result,type);
//            if(!writeSuccess){
//                result.setFailure("正面半身照上传服务器有误");
//                return result;
//            }
//
//        }
//        if (big2M(sideFacePhoto)) {
//            result.setFailure("侧面半身照大小不能超过2M");
//            return result;
//        }else{
//            type= "sidefacephoto";
//            boolean writeSuccess =  writeFile2Location(sideFacePhoto,name,mobile,students, result,type);
//            if(!writeSuccess){
//                result.setFailure("侧面半身照上传服务器有误");
//                return result;
//            }
//        }
//        if (big2M(fullBodyPhoto)) {
//            result.setFailure("全身照大小不能超过2M");
//            return result;
//        }else{
//            type= "fullbodyphoto";
//            boolean writeSuccess =  writeFile2Location(fullBodyPhoto,name,mobile,students, result,type);
//            if(!writeSuccess){
//                result.setFailure("全身照上传服务器有误");
//                return result;
//            }
//        }
//        if (big10M(videoIntroduction)) {
//            result.setFailure("视频大小不能超过10M");
//            return result;
//        }else{
//            type= "videointroduction";
//            boolean writeSuccess =   writeFile2Location(videoIntroduction,name,mobile,students, result,type);
//            if(!writeSuccess){
//                result.setFailure("视频上传服务器有误");
//                return result;
//            }
//        }

//        int i = studentsService.commitPersonDetailInformation(students);
//        if (i == 0) {
//            result.setFailure("提交失败");
//        } else {
//            result.setSuccess("提交成功");
//        }
        return result;
    }





    private boolean writeFile2Location(MultipartFile file, String name, String mobile, Students students, ResponseMessage<String> result,String type){
        // 设置文件存储路径
        StringBuilder filePath = new StringBuilder("/picture");
        // 创建/picture/姓名+手机号文件夹
        String studentDir = filePath.append(File.separator).append(name).append(mobile).toString();

        students.setImgpath(studentDir);
        File dirFile = new File(studentDir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        //重命名
        if ("fullfacephoto".equals(type)){
            filePath.append(File.separator).append("正面半身照");
        }else if("sidefacephoto".equals(type)){
            filePath.append(File.separator).append("侧面半身照");
        }else if("fullbodyphoto".equals(type)){
            filePath.append(File.separator).append("正面全身照");
        }else if("videointroduction".equals(type)){
            filePath.append(File.separator).append("1分钟视频");
        }
        try {
            File dest = new File(filePath.toString());
            // 文件写入
            file.transferTo(dest);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            result.setException(e.getMessage());
            return false;
        }

    }
}
