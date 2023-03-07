package com.example.springboot_junit_demo.OpenFeign;

import com.example.springboot_junit_demo.RetrofitTest.NoticePush;
import com.example.springboot_junit_demo.RetrofitTest.ZsSaveWord.ResponseBodys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class OpenFeignController {
    @Autowired
    OpenFeignService openFeignService;
    @GetMapping("/findWorldList")
    public NoticePush zsWorldList(){
//        openFeignService.findMyorders();
        NoticePush myorders = openFeignService.findMyorders();
        return myorders;
    }

    @GetMapping("save")
    public ResponseBodys saveWord(){
        ResponseBodys responseBodys = openFeignService.saveWord();
        return responseBodys;
    }
    @GetMapping("/findMaterial")
    public void findMaterial(){
        openFeignService.findMaterial();
    }
}
