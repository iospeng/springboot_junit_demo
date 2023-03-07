package com.example.springboot_junit_demo.timerTaskJob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class MaterialTimerTask {
//    @Scheduled(cron = "0 0/1 * * * ?") //cron 表达式, 每分钟执行一次
    public void getMaterial(){
        log.info("定时任务触发，每分钟执行一次{}",new Date());
        log.info("定时任务触发，每分钟执行一次{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
