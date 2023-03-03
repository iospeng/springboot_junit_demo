package com.example.springboot_junit_demo.RetrofitTest.HnWhiteList;

import com.example.springboot_junit_demo.RetrofitTest.NoticePush;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Retrofit 请求第三方接口
 * @Header: 该注解以参数的形式使用，为动态添加请求头，key：不可改变 value：可变
 */
@Component
public interface WhiteListInterface {
    @GET("white/list")
    Call<ResponseWhiteList> findAll(@Header("cookie") String cookie, @Query("page") Integer page,
                                    @Query("size") Integer size,
                                    @Query("queryCondition") String queryCondition,
                                    @Query("sort") String sort);
}
