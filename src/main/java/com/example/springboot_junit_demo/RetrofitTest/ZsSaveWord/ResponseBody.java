package com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord;

import lombok.Data;

@Data
public class ResponseBody {
    private Integer code;
    private Object Data;
    private String msg;
    private boolean success;
}
