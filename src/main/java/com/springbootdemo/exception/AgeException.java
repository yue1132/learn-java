package com.springbootdemo.exception;

import com.springbootdemo.enums.ResultEnum;

public class AgeException extends RuntimeException {

    private Integer code;

    public AgeException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
