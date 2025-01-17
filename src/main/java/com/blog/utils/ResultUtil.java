package com.blog.utils;

import com.blog.model.Result;

/**
 * @author: bingo
 * @Date: 2019/11/18 19:13
 * Describe: 返回统一格式封装工具
 */
public class ResultUtil {

    public static Result success(String msg) {
        return success(null, msg);
    }

    public static Result success(Object object, String msg) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result success(Integer code, Object object, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
