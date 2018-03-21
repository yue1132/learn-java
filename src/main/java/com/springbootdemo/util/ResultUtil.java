package com.springbootdemo.util;

public class ResultUtil {

    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        result.setData(obj);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        result.setData(null);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
