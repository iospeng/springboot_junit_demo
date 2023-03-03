package com.example.springboot_junit_demo.RetrofitTest;

import lombok.Data;

import java.util.List;

@Data
public class NoticePush {
    private Integer code;
    private String msg;
    private DatePush data;
    private boolean success;
}
