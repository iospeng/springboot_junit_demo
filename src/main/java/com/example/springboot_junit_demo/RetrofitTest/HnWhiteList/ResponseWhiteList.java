package com.example.springboot_junit_demo.RetrofitTest.HnWhiteList;

import com.example.springboot_junit_demo.RetrofitTest.zsOrder;
import lombok.Data;

import java.util.List;

@Data
public class ResponseWhiteList {
    private List<ProblemWhitelist> rows;
//    private boolean success;
    private Integer total;
}
