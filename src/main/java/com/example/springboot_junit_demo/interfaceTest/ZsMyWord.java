package com.example.springboot_junit_demo.interfaceTest;

import com.example.springboot_junit_demo.conf.InterfacePath;
import com.example.springboot_junit_demo.domin.ResponseCode;
import com.example.springboot_junit_demo.domin.ResponseData;
import com.example.springboot_junit_demo.unit.UrlCode;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@Slf4j
public class ZsMyWord {

    UrlCode urlCode = new UrlCode();
    /**
     * 发送get请求,舟山12328我的工单列表查询
     * @return
     */
    public ResponseEntity<String> requestMyWord(String cookie){
        RestTemplate restTemplate = new RestTemplate();
        //参数准备
        Map<String,String> param = new HashMap<>();
        List<Map<String,String >> rules = new ArrayList<>();
        //rules.add(param);
        List<Map<String ,Object>> groups = new ArrayList<>();
        Map<String,Object> s = new HashMap<>();
        s.put("rules",rules);
        s.put("groups",groups);
        s.put("op","and");
        String codes = s.toString();
        //url编码解码
        String urlEnCode = urlCode.urlEncoding(codes);
        //拼接url
        String url = InterfacePath.zs12328WordOrder+ "?page=0&size=10&queryCondition="+urlEnCode+"&sort=taskDeadLineTime,desc";
        //切换消息转换器，用于将json数据转换为pojo数据，表示用StringHttpMessageConverter 消息转换器代替list索引为1的转换器
        //解决可能出现的响应中文乱码问题
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
//        headers.add("Cookie","JSESSIONID=4F341E7857C4F2212B8AF4374AE8A326");
//        headers.add("Cookie",cookie);
        headers.add(HttpHeaders.COOKIE,cookie);
//        log.info("传参：cookie={}",cookie);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        //发送请求
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
//        log.info("请求头：{}", response.getHeaders());
        System.out.println(response.getBody());
        return response;
    }

    /**
     * post请求，舟山12328新增自定义工单
     * @return
     */
    public ResponseEntity<String> saveOrder(){
        RestTemplate restTemplate = new RestTemplate();
        //准备数据
        Map<String,String > orderParm = new HashMap<>();
        orderParm.put("attachIds","");
        orderParm.put("customSubtypeCode","1");
        orderParm.put("customSubtypeName","语文");
        orderParm.put("detail","哈哈哈");
        orderParm.put("registerDepName","局领导");
        orderParm.put("registerId","ff808081818b6a4e01827c6b74d4017c");
        orderParm.put("registerName","测试舟山1");
        orderParm.put("ywarea","3");
        orderParm.put("ywareaName","普陀区");
        orderParm.put("ywtype","10");
        orderParm.put("ywtypeName","自定义");
        orderParm.put("ywtypefullname","语文");
        orderParm.put("ywtypeid","1");

        String ulr = "http://192.168.90.163:9114/dtr/workOrder/manual/save";
        //设置编码及转换器
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        headers.add("Cookie","JSESSIONID=3A76C524A11325574D6FC0E98AB48F97");
        //将请求头，请求体放入请求
        HttpEntity<Map<String,String >> entity = new HttpEntity<>(orderParm,headers);

        //发送请求
        ResponseEntity<String> response = restTemplate.exchange(ulr,HttpMethod.POST,entity,String.class);
        System.out.println(response);
        log.info("请求头：{}", response.getHeaders());
        System.out.println(response.getBody());

        return response;
    }

    /**
     * 登录
     * @return
     */
    public ResponseEntity<String> zsLogin(){
        RestTemplate restTemplate = new RestTemplate();
        //准备数据
        String userNameId = "ff808081818b6a4e01827c6b74d4017c";
        String token = "123456";
        //url
        String url = "http://192.168.90.101/sso-auth/rest/sso/login?username=" + userNameId +
                "&token=" + token + "&service=http://192.168.90.163:4800/dtr/&action=login&rememberMe=false&" +
                "callback=beyond_callback_34";
        //设置编码及转换器
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        //发送请求
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        log.info("请求头：{}",exchange.getHeaders());
//        log.info("cookie :{}",exchange.getHeaders().get("Set-Cookie"));
        return exchange;
    }
}
