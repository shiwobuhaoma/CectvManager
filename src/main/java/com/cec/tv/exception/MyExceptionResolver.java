package com.cec.tv.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();

        if (e instanceof UnknownAccountException ||  e instanceof IncorrectCredentialsException){
            mv.setViewName("redirect:/user/login");
        }else if(e instanceof UnauthorizedException){
            mv.setViewName("redirect:/user/unAuthorization");
        }

        return mv;
    }
}
