package com.example.springboot_junit_demo.RetrofitTest;

import com.example.springboot_junit_demo.OpenFeign.OpenFeignInterface;
import com.example.springboot_junit_demo.conf.InterfacePath;
import com.example.springboot_junit_demo.domin.ResponseData;
import com.example.springboot_junit_demo.unit.UrlCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class RetrofitService {
    UrlCode urlCode = new UrlCode();
    @Autowired
    OpenFeignInterface openFeignInterface;

    public void pushRetrofit() {
        /**
         * 解决错误
         * com.google.gson.stream.MalformedJsonException:
         * Use JsonReader.setLenient(true) to accept malformed JSON at line 4 column 1 path $
         */
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfacePath.zsdtr)
                .addConverterFactory(GsonConverterFactory.create(gson)) // 解决错误：Java.lang.IllegalArgumentException: Unable to create converter for class
                .build();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

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

        Response<NoticePush> all = null;
        Call<NoticePush> call = null;
        try {
            all = retrofitInterface.findAll(0, 10, urlEnCode, "taskDeadLineTime,desc").execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("请求体：{}",all.body());
        log.info("工单列表：Retofit:{}", all);
    }
}
