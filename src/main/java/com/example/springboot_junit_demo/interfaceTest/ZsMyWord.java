package com.example.springboot_junit_demo.interfaceTest;

import com.example.springboot_junit_demo.conf.InterfacePath;
import com.example.springboot_junit_demo.domin.ResponseCode;
import com.example.springboot_junit_demo.domin.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@Slf4j
public class ZsMyWord {
    /**
     * 发送get请求
     * @return
     */
    public ResponseEntity requestMyWord(){
        RestTemplate restTemplate = new RestTemplate();
        //参数准备
        Map<String,String> param = new HashMap<>();
        List<Map<String,String >> rules = new ArrayList<>();
//        rules.add(param);
        List<Map<String ,Object>> groups = new ArrayList<>();
        Map<String,Object> s = new HashMap<>();
        s.put("rules",rules);
        s.put("groups",groups);
        s.put("op","and");
        //url编码解码
        String urlEnCode = null;
        try {
            //编码
            urlEnCode = URLEncoder.encode(s.toString(),"UTF-8");
            //解码
            System.out.println("url解码后：" + URLDecoder.decode(urlEnCode,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        //拼接url
        String url = InterfacePath.zs12328WordOrder+ "?page=0&size=10&queryCondition="+urlEnCode+"&sort=taskDeadLineTime,desc";
        System.out.println(url);
        //切换消息转换器，用于将json数据转换为pojo数据，表示用StringHttpMessageConverter 消息转换器代替list索引为1的转换器
        //解决可能出现的响应中文乱码问题
//        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        headers.add("Cookie","JSESSIONID=4F341E7857C4F2212B8AF4374AE8A326");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        //发送请求
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        log.info("请求头：{}", response.getHeaders());
        System.out.println(response.getBody());
        return response;
    }
}
