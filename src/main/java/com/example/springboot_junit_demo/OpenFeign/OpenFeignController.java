package com.example.springboot_junit_demo.OpenFeign;

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
    public void zsWorldList(){
//        openFeignService.findMyorders();
        openFeignService.findMyorders();
    }
    @GetMapping("/findMaterial")
    public void findMaterial(){
        openFeignService.findMaterial();
    }
}
