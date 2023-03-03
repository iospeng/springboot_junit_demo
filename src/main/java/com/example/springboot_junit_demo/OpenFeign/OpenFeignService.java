package com.example.springboot_junit_demo.OpenFeign;

import com.example.springboot_junit_demo.OpenFeign.OpenFeignInterface;
import com.example.springboot_junit_demo.RetrofitTest.NoticePush;
import com.example.springboot_junit_demo.unit.UrlCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    public void findMyorders (){
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
        String cookie = "JSESSIONID=B531CD40C05D5F046BA5698C79105829";
        NoticePush myOrder =openFeignInterface.findMyOrder(0, 10, urlEnCode, "taskDeadLineTime,desc",cookie);
        log.info("我的工单列表请求数据：{}",myOrder);
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
        String cookie = "JSESSIONID=B531CD40C05D5F046BA5698C79105829";
        String myOrder =openFeignInterface.findMaterial(cookie,0, 10, urlEnCode, "submitTime,desc");
        log.info("报送材料请求数据：{}",myOrder);
    }
}
