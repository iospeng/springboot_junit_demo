package com.example.springboot_junit_demo.RetrofitTest.HnWhiteList;

import com.example.springboot_junit_demo.OpenFeign.OpenFeignInterface;
import com.example.springboot_junit_demo.RetrofitTest.NoticePush;
import com.example.springboot_junit_demo.RetrofitTest.RetrofitInterface;
import com.example.springboot_junit_demo.conf.InterfacePath;
import com.example.springboot_junit_demo.unit.UrlCode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
public class WhiteListRetrofitService {
    UrlCode urlCode = new UrlCode();

    public void pushRetrofit() {
        /**
         * 解决错误
         * com.google.gson.stream.MalformedJsonException:
         * Use JsonReader.setLenient(true) to accept malformed JSON at line 4 column 1 path $
         */
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfacePath.hn)
                .addConverterFactory(GsonConverterFactory.create(gson)) // 解决错误：Java.lang.IllegalArgumentException: Unable to create converter for class
                .build();
        WhiteListInterface whiteListInterface = retrofit.create(WhiteListInterface.class);
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

        Response<ResponseWhiteList> all = null;
        String cookie = "JSESSIONID=E70F7571D160A9E990E7CC56AC9A1250; tokens=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyZWFsTGV2ZWwiOiIzIiwic3ViIjoi6K-45pqo5paH5peF5LyB5Lia56uvIiwicGhvbmUiOiIxODg1ODY3MDg3MCIsIm5hbWUiOiLpmYjpnJ4iLCJpZCI6IjhhZmFjMGNjNmI5ZjZjMWMwMTZiYjFlMzkwYjAwMmI4IiwidHlwZSI6IjEiLCJpYXQiOjE2NDk4NDEzNTUsImFjY291bnQiOiIzMzEwODIxOTk2MTExMTYyMjUifQ.d1kw8zxkpRqx3QOZEkiQwF7KzKitt1g4DPZ8iCc3_d0";
        try {
            all = whiteListInterface.findAll(cookie,0, 25, urlEnCode, "updatedTime,desc").execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("请求体：{}",all.body());
        log.info("白名单列表：Retofit:{}", all);
    }
}
