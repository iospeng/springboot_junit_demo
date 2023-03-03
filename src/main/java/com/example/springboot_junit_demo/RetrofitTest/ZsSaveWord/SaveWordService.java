package com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord;

import com.example.springboot_junit_demo.conf.InterfacePath;
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

@Component
@Slf4j
public class SaveWordService {
    public void saveWord(Manual manual, String cookie){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfacePath.zsdtr)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        SaveWordInterFace saveWordInterFace = retrofit.create(SaveWordInterFace.class);
        Response<ResponseBody> res = null;
        try {
            res = saveWordInterFace.saveWord(cookie, manual).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("返回值：{}",res);
        log.info("请求体返回值：{}",res.body());


    }

}
