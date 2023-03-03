package com.example.springboot_junit_demo.RetrofitTest;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DatePush {
    private List<zsOrder> data;
    private boolean success;
    private Integer total;
}
