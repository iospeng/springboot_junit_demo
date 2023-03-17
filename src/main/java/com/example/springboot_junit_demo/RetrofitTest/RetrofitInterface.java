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
    @Headers("Cookie:JSESSIONID=E70F7571D160A9E990E7CC56AC9A1250; tokens=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyZWFsTGV2ZWwiOiIzIiwic3ViIjoi6K-45pqo5paH5peF5LyB5Lia56uvIiwicGhvbmUiOiIxODg1ODY3MDg3MCIsIm5hbWUiOiLpmYjpnJ4iLCJpZCI6IjhhZmFjMGNjNmI5ZjZjMWMwMTZiYjFlMzkwYjAwMmI4IiwidHlwZSI6IjEiLCJpYXQiOjE2NDk4NDEzNTUsImFjY291bnQiOiIzMzEwODIxOTk2MTExMTYyMjUifQ.d1kw8zxkpRqx3QOZEkiQwF7KzKitt1g4DPZ8iCc3_d0")
    @GET("workOrder/task/handle/list")
    Call<NoticePush> findAll(@Query("page") Integer page,
                           @Query("size") Integer size,
                           @Query("queryCondition") String queryCondition,
                           @Query("sort") String sort);
}
