package com.example.springboot_junit_demo.RetrofitTest.HnWhiteList;

import com.example.springboot_junit_demo.RetrofitTest.DatePush;
import lombok.Data;

@Data
public class WhiteListPush {
    private Integer code;
    private String msg;
    private ResponseWhiteList data;
    private boolean success;
}
