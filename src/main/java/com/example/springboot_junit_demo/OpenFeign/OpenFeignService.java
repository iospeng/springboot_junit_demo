package com.example.springboot_junit_demo.OpenFeign;

import com.example.springboot_junit_demo.OpenFeign.OpenFeignInterface;
import com.example.springboot_junit_demo.RetrofitTest.NoticePush;
import com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord.Manual;
import com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord.ResponseBodys;
import com.example.springboot_junit_demo.conf.InterfacePath;
import com.example.springboot_junit_demo.unit.UrlCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
@Slf4j
public class OpenFeignService {
    @Autowired
    OpenFeignInterface openFeignInterface;
    UrlCode urlCode = new UrlCode();

    /**
     * 舟山12328我的工单
     */
    public NoticePush findMyorders (){
        //参数准备
        Map<String, String> param = new HashMap<>();
        List<Map<String, String>> rules = new ArrayList<>();
        //rules.add(param);
        List<Map<String, Object>> groups = new ArrayList<>();
        Map<String, Object> s = new HashMap<>();
        s.put("rules", rules);
        s.put("groups", groups);
        s.put("op", "and");
        String codes = s.toString();
        //url编码解码
        String urlEnCode = urlCode.urlEncoding(codes);
        NoticePush myOrder =openFeignInterface.findMyOrder(0, 10, urlEnCode, "taskDeadLineTime,desc",
                InterfacePath.zsCookie);
        log.info("我的工单列表请求数据：{}",myOrder);
        return myOrder;
    }

    public ResponseBodys saveWord(){
        Manual manual = new Manual();
        manual.setCustomSubtypeCode("1");
        manual.setCustomSubtypeName("语文");
        manual.setDetail("手工添加");
        manual.setRegisterDepName("局领导");
        manual.setRegisterId("ff808081818b6a4e01827c6b74d4017c");
        manual.setRegisterName("测试舟山1");
        manual.setYwarea("2");
        manual.setYwareaName("定海区");
        manual.setYwtype("10");
        manual.setYwtypeName("自定义");
        manual.setYwtypefullname("语文");
        manual.setYwtypeid("1");
        ResponseBodys responseBody = openFeignInterface.saveWord(InterfacePath.zsCookie, manual);
        log.info("添加工单：{}",responseBody);
        return responseBody;
    }

    /**
     * 舟山报送材料
     */
    public void findMaterial (){
        //参数准备
        Map<String, String> param = new HashMap<>();
        List<Map<String, String>> rules = new ArrayList<>();
        //rules.add(param);
        List<Map<String, Object>> groups = new ArrayList<>();
        Map<String, Object> s = new HashMap<>();
        s.put("rules", rules);
        s.put("groups", groups);
        s.put("op", "and");
        String codes = s.toString();
        //url编码解码
        String urlEnCode = urlCode.urlEncoding(codes);
        String myOrder =openFeignInterface.findMaterial(InterfacePath.zsCookie,0, 10, urlEnCode, "submitTime,desc");
        log.info("报送材料请求数据：{}",myOrder);
    }
}
