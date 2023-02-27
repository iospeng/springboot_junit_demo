package com.example.springboot_junit_demo.JunitTest;

import com.example.springboot_junit_demo.interfaceTest.ZsMyWord;
import com.example.springboot_junit_demo.unit.UrlCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
public class TestZsInterface {
//    private List<String> cookies = null;
    private String cookies = "JSESSIONID=381297DE8CA960365ADA94B2F0E1EB7C";

    ZsMyWord zsMyWord = new ZsMyWord();
    UrlCode urlCode = new UrlCode();
    @Test
    public void  testZs12328WordOrder(){
        Object o = zsMyWord.requestMyWord(cookies);
        log.info("请求结果：{}",o);
    }
    @Test
    public void  testZsSaveOrder(){
        Object o = zsMyWord.saveOrder();
        log.info("请求结果：{}",o);
    }
//    @Before
//    public void testLogin(){
//        ResponseEntity<String> entity = zsMyWord.zsLogin();
//        cookies = entity.getHeaders().get("Set-Cookie");
//        log.info("登录请求头：{}",entity.getHeaders());
//        log.info("请求结果：{}",entity);
//    }
}
