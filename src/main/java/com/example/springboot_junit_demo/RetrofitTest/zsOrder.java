package com.example.springboot_junit_demo.RetrofitTest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class zsOrder {
    private Integer backBtn;
    private String carLicenseNum;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDate createdTime;
    private String createdTime;
    private String fromtype;
    private String fromtypeName;
    private String id;
    private Integer isReplenish;
    private String name;
    private String relatedId;
    private String remark;
    private String serialNumber;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDate taskDeadLineTime;
    private String taskDeadLineTime;
    private String taskDispatcherId;
    private String taskDispatcherName;
    private String taskStatus;
    private Integer urgeBtn;
    private Integer urgeNum;
    private String ywarea;
    private String ywareaName;
    private String ywtype;
    private String ywtypeName;
}
