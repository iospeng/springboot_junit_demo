package com.example.springboot_junit_demo.RetrofitTest;

//import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @Author syh
 * @create 2021/8/19 19:18
 */
@Data
public class ImsVehicleQueryVO {

//    @ApiParam("是否黑名单")
    private Boolean isBlackVehicle;

//    @ApiParam("是否待抓捕")
    private Boolean isPendingVehicle;


//    @ApiParam("是否白名单")
    private Boolean isWhiteVehicle;

//    @ApiParam("车牌颜色")
    private Integer plateColor;

//    @ApiParam("车牌号")
    private String plateNumber;
}
