package com.example.springboot_junit_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling //开启定时任务
@EnableFeignClients(basePackages = {"com.example.springboot_junit_demo.**"}) // 开启Feign功能
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.example.springboot_junit_demo"})
public class SpringbootJunitDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJunitDemoApplication.class, args);
    }

}
