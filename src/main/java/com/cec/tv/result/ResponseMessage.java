package com.cec.tv.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
