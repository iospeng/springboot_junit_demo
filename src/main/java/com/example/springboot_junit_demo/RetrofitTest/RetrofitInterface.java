package com.example.springboot_junit_demo.RetrofitTest;

import com.example.springboot_junit_demo.domin.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Retrofit 请求第三方接口
 * @Headers: 该注解用在接口方法上面，为静态添加请求头，key:value 不可改变
 */
@Component
public interface RetrofitInterface {
    @Headers("Cookie:JSESSIONID=8C9554F52FFC14FF019B9657A2A445A5")
    @GET("workOrder/task/handle/list")
    Call<NoticePush> findAll(@Query("page") Integer page,
                           @Query("size") Integer size,
                           @Query("queryCondition") String queryCondition,
                           @Query("sort") String sort);
}
