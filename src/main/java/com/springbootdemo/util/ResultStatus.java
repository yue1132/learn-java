package com.springbootdemo.util;

/**
 * ResultStatus
 */
public enum ResultStatus {

    SUCCESS(0),ERROR(1);

    private Integer code;

    ResultStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
