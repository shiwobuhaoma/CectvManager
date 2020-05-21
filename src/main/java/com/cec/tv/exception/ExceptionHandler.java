package com.cec.tv.exception;

import com.cec.tv.result.ResponseMessage;
import com.cec.tv.result.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseMessage handel(Exception e){
        if(e instanceof MyException){
            MyException myException =(MyException)e;
            return new ResponseMessage(myException.getCode(),myException.getMessage());
        }else {
            logger.error("[系统异常] {}",e);
            return new ResponseMessage(ResultEnum.SYSTEM_ERROR);
        }
    }
}
