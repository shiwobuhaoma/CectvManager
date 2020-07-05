package com.cec.tv.result;

import java.io.Serializable;


public class ResponseMessage<T> implements Serializable {

    private String message;
    private String token;
    private String exception;
    private int code;
    private T data;

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;

    }

    public ResponseMessage(ResultEnum systemError) {
        this.code = systemError.getCode();
        this.message = systemError.getMsg();

    }

    public ResponseMessage() {

    }


    public ResponseMessage<T> setSuccess(String message) {
        this.code = 1;
        this.message = message;

        return this;
    }



    public ResponseMessage<T> setFailure(String message) {
        this.code = 0;
        this.message = message;

        return this;
    }

    public void setResultEnum(ResultEnum addCategory) {
        this.code = addCategory.getCode();
        this.message = addCategory.getMsg();

    }

    public void setData(T list) {
        data = list;
    }

    public void setToken(String id) {
        token = id;
    }

    public void setException(String message) {
        exception = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getException() {
        return exception;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }
}
