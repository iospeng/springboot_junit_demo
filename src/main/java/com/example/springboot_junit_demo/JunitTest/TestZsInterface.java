package com.example.springboot_junit_demo.JunitTest;

import com.example.springboot_junit_demo.interfaceTest.ZsMyWord;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
public class TestZsInterface {
    @Test
    public void  testZs12328WordOrder(){
        ZsMyWord zsMyWord = new ZsMyWord();
        Object o = zsMyWord.requestMyWord();
        log.info("请求结果：{}",o);
    }
}
