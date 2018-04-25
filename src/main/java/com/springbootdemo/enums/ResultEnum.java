package com.springbootdemo.enums;

public enum ResultEnum {
    SUCCESS(0,"成功"),
    UNKNOWN_ERROR(-1,"未知错误"),
    RRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中")
    ;

    private Integer code;

    private String msg;


    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
