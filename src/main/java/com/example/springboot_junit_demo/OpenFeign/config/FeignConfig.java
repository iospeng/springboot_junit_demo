package com.example.springboot_junit_demo.OpenFeign.config;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <p>Description: Feign配置类</p>
 * <p>Date: 2021/8/13 4:24 下午 </p>
 *
 * @author HaoJie Luo
 * @version V1.0.0
 * ClassName: FeignConfig
 */

@Configuration
public class FeignConfig {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
