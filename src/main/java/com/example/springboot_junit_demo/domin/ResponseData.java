package com.example.reggie.domin;

import java.io.Serializable;

/**
 * 通用返回结果类
 */
public class ResponseData implements Serializable {
    private int code;
    private Object data;
    private String msg;

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
