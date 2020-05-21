package com.cec.tv.controller;


import com.cec.tv.config.Constant;
import com.cec.tv.model.User;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.result.ResultEnum;
import com.cec.tv.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
@Api(tags = "用户相关接口", description = "提供用户相关的API")
@RequestMapping("/user/")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录接口",httpMethod="POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public ResponseMessage<String> userLogin(@RequestBody User user) {
        ResponseMessage<String> result = new ResponseMessage<>();
        if (user != null){
            String userName = user.getUsername();
            String passWord = user.getUserpwd();
            //1.获取Subject
            Subject subject = SecurityUtils.getSubject();
            //2.封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord);
            try {
                //3.执行登录方法
                subject.login(token);
                result.setResultEnum(ResultEnum.SUCCESS);
                result.setToken(subject.getSession().getId().toString());
            } catch (UnknownAccountException e) {
                //e.printStackTrace();
                //登录失败:用户名不存在
                result.setResultEnum(ResultEnum.UNKNOWN_ERROR);
            }catch (IncorrectCredentialsException e) {
                //e.printStackTrace();
                //登录失败:密码错误
                result.setResultEnum(ResultEnum.PASSWORD_ERROR);
            }
        }else{
            result.setResultEnum(ResultEnum.EMPTY_USERNAME_OR_PASSWORD);
        }
        return result;
    }



    @ApiOperation(value = "退出登录接口",httpMethod="POST")
    @ResponseBody
    @RequiresAuthentication
    @RequestMapping(value = "logout", method = {RequestMethod.POST})
    public ResponseMessage<String> logout(@RequestParam String userId) {
        User user = new User();
        user.setId(Long.valueOf(userId));
        int i = userService.updateLoginStatus(user);
        ResponseMessage<String> result = new ResponseMessage<>();
        if (i != 0) {
            result.setSuccess("退出成功");
        } else {
            result.setFailure("退出失败");
        }
        return result;
    }

    @ApiOperation(value = "忘记密码",httpMethod="POST")
    @ResponseBody
    @RequestMapping("forgetPwd")
    public ResponseMessage<String> ForgetPwd(){

        return null;
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     */
    @ApiIgnore
    @ApiOperation("未登录")
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public ResponseMessage<String> unauth() {
        ResponseMessage<String> result = new ResponseMessage<>();
        result.setResultEnum(ResultEnum.NEED_LOGIN);
        return result;
    }

    @ApiIgnore
    @ApiOperation("没有权限")
    @RequestMapping(value = "/unAuthorization")
    @ResponseBody
    public ResponseMessage<String> unAuthorization() {
        ResponseMessage<String> result = new ResponseMessage<>();
        result.setResultEnum(ResultEnum.NOT_PERMISSION);
        return result;
    }

    @ApiOperation(value = "注册接口",httpMethod="POST")
    @Transactional
    @ResponseBody
    @RequestMapping("register")
    public ResponseMessage<String> register(@RequestBody User user) {
        ResponseMessage<String> result = new ResponseMessage<>();
        if (user != null) {
            user.setIslogin(0);
            user.setCreatedate(new Date());
            user.setIsdel(false);
            int su = userService.register(user);
            if (su > 0) {
                result.setResultEnum(ResultEnum.SUCCESS);
            }else{
                result.setResultEnum(ResultEnum.REPEAT_REGISTER);
            }
        }else{
            result.setResultEnum(ResultEnum.EMPTY_PARAMETER);
        }
        return result;
    }
}
