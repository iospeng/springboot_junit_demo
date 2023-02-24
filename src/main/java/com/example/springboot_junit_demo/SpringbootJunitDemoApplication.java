package com.example.springboot_junit_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@Slf4j
@SpringBootApplication
@ServletComponentScan
public class SpringbootJunitDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJunitDemoApplication.class, args);
    }

}
