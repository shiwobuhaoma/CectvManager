package com.cec.tv.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage<T> {
    private String message;
    private String token;
    private int code;
    private T data;

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
        set();
    }

    public ResponseMessage(ResultEnum systemError) {
        this.code = systemError.getCode();
        this.message = systemError.getMsg();
        set();
    }


    public ResponseMessage<T> setSuccess(String message) {
        this.code = 1;
        this.message = message;
        set();
        return this;
    }



    public ResponseMessage<T> setFailure(String message) {
        this.code = 0;
        this.message = message;
        set();
        return this;
    }

    public void setResultEnum(ResultEnum addCategory) {
        this.code = addCategory.getCode();
        this.message = addCategory.getMsg();
        set();
    }

    private void set() {
        Subject subject = SecurityUtils.getSubject();
        this.token = subject.getSession().getId().toString();
    }
}
