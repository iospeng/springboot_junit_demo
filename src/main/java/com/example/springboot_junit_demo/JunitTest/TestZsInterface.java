package com.example.springboot_junit_demo.JunitTest;

import com.example.springboot_junit_demo.OpenFeign.OpenFeignService;
import com.example.springboot_junit_demo.RetrofitTest.HnWhiteList.WhiteListRetrofitService;
import com.example.springboot_junit_demo.RetrofitTest.RetrofitService;
import com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord.Manual;
import com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord.SaveWordService;
import com.example.springboot_junit_demo.interfaceTest.ZsMyWord;
import com.example.springboot_junit_demo.unit.UrlCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestZsInterface {
//    private List<String> cookies = null;
    private String cookies = "JSESSIONID=5C932DF40B94EC382D9FCF8E0AD90E02";
    ZsMyWord zsMyWord = new ZsMyWord();
    UrlCode urlCode = new UrlCode();

    /**
     * 每条用例执行之前执行
     */
    //    @Before
//    public void testLogin(){
//        ResponseEntity<String> entity = zsMyWord.zsLogin();
//        List<String> setCookie = entity.getHeaders().get("Set-Cookie");
////        String setC = setCookie.get(0);
////        String cookie = setC.substring(setC.indexOf("=")+1, setC.indexOf(";"));
////        ResponseEntity<String> dtrEntity = zsMyWord.zsDtr(cookie);
//        log.info("登录请求头：{}",entity.getHeaders());
//        log.info("请求结果：{}",entity);
//    }

    /**
     * 我的工单 列表查询
     */
    @Test
    public void  testZs12328WordOrder(){
        Object o = zsMyWord.requestMyWord(cookies);
        log.info("请求结果：{}",o);
    }

    /**
     * 人工登记工单
     */
    @Test
    public void  testZsSaveOrder(){
        Object o = zsMyWord.saveOrder();
        log.info("请求结果：{}",o);
    }

    @Test
    public void testRetrofit(){
        RetrofitService retrofitService = new RetrofitService();
        retrofitService.pushRetrofit();
    }

    @Test
    public void testOpenfeign(){
        OpenFeignService openFeignService = new OpenFeignService();
        openFeignService.findMyorders();
    }

    @Test
    public void testFindMaterial(){
        OpenFeignService openFeignService = new OpenFeignService();
        openFeignService.findMyorders();
    }

    @Test
    public  void testFindWhiteList(){
        WhiteListRetrofitService whiteListRetrofitService = new WhiteListRetrofitService();
        whiteListRetrofitService.pushRetrofit();
    }

    /**
     * 人工添加工单
     */
    @Test
    public void testsaveWord(){
        Manual manual = new Manual();
        manual.setCustomSubtypeCode("3");
        manual.setCustomSubtypeName("英语");
        manual.setDetail("手工添加");
        manual.setRegisterDepName("虚拟机构");
        manual.setRegisterId("SYSTEM");
        manual.setRegisterName("超级管理员");
        manual.setYwarea("2");
        manual.setYwareaName("定海区");
        manual.setYwtype("10");
        manual.setYwtypeName("自定义");
        manual.setYwtypefullname("英语");
        manual.setYwtypeid("3");
//        String cookie = "${zhouSan.cookie}";
        String cookie = "JSESSIONID=B531CD40C05D5F046BA5698C79105829";
        SaveWordService saveWordService = new SaveWordService();
        saveWordService.saveWord(manual,cookie);
    }


}
