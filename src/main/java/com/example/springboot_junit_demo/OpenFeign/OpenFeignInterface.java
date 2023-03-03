package com.example.springboot_junit_demo.OpenFeign;

import com.example.springboot_junit_demo.OpenFeign.config.FeignConfig;
import com.example.springboot_junit_demo.OpenFeign.config.FeignRequestInterceptor;
import com.example.springboot_junit_demo.RetrofitTest.NoticePush;
import com.example.springboot_junit_demo.conf.InterfacePath;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import retrofit2.http.Header;
import retrofit2.http.Headers;

@FeignClient(name = "OpenFeignInterface", url = InterfacePath.zsdtr,
        configuration = {FeignConfig.class, FeignRequestInterceptor.class})
public interface OpenFeignInterface {
    @GetMapping(value = "workOrder/task/handle/list?page={page}&size={size}$queryCondition={queryCondition}&sort={sort}")
    public NoticePush findMyOrder(@PathVariable("page") Integer page,
                                  @PathVariable("size") Integer size,
                                  @PathVariable("queryCondition") String queryCondition,
                                  @PathVariable("sort") String sort,
                                  @Header("cookie") String cookie);

//    @Headers("Cookie:JSESSIONID=B531CD40C05D5F046BA5698C79105829")
    @GetMapping(value = "material/list?page={page}&size={size}$queryCondition={queryCondition}&sort={sort}")
    public String findMaterial(@RequestHeader("cookie") String cookie, @PathVariable("page") Integer page,
                               @PathVariable("size") Integer size,
                               @PathVariable("queryCondition") String queryCondition,
                               @PathVariable("sort") String sort);
}
