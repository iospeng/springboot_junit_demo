package com.example.springboot_junit_demo.OpenFeign;

import com.example.springboot_junit_demo.OpenFeign.config.FeignConfig;
import com.example.springboot_junit_demo.OpenFeign.config.FeignRequestInterceptor;
import com.example.springboot_junit_demo.RetrofitTest.NoticePush;
import com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord.Manual;
import com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord.ResponseBodys;
import com.example.springboot_junit_demo.conf.InterfacePath;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@FeignClient(name = "OpenFeignInterface", url = InterfacePath.zsdtr,
        configuration = {FeignConfig.class, FeignRequestInterceptor.class})
public interface OpenFeignInterface {
    /**
     * get请求 查询我的工单列表
     * RequestHeader：设置cookie，且required必须设置为true
     * @param page
     * @param size
     * @param queryCondition
     * @param sort
     * @param cookie
     * @return
     */
    @GetMapping(value = "workOrder/task/handle/list?page={page}&size={size}$queryCondition={queryCondition}&sort={sort}")
    public NoticePush findMyOrder(@PathVariable("page") Integer page,
                                  @PathVariable("size") Integer size,
                                  @PathVariable("queryCondition") String queryCondition,
                                  @PathVariable("sort") String sort,
                                  @RequestHeader(name = "cookie", required = true) String cookie);

    /**
     * post请求，人工新增工单
     * @param cookie
     * @param manual
     * @return
     */
    @PostMapping("workOrder/manual/save")
    public ResponseBodys saveWord(@RequestHeader(name = "cookie", required = true) String cookie,
                                  @RequestBody Manual manual);

    /**
     * get请求，查询报送材料列表
     * @param cookie
     * @param page
     * @param size
     * @param queryCondition
     * @param sort
     * @return
     */
//    @Headers("Cookie:JSESSIONID=B531CD40C05D5F046BA5698C79105829")
    @GetMapping(value = "material/list?page={page}&size={size}$queryCondition={queryCondition}&sort={sort}")
    public String findMaterial(@RequestHeader(name = "cookie", required = true) String cookie,
                               @PathVariable("page") Integer page,
                               @PathVariable("size") Integer size,
                               @PathVariable("queryCondition") String queryCondition,
                               @PathVariable("sort") String sort);
}
