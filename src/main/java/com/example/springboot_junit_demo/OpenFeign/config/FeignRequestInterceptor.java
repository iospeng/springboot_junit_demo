package com.example.springboot_junit_demo.OpenFeign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(HttpHeaders.COOKIE,"JSESSIONID=FB098DEA32A291D733D2BEBD83A6819E");
    }
}
