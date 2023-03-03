package com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Component
public interface SaveWordInterFace {
    @POST("workOrder/manual/save")
    public Call<ResponseBody> saveWord(@Header("cookie") String cookie, @Body Manual manual);
}
