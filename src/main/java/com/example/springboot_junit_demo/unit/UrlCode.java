package com.example.springboot_junit_demo.unit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@RestController
@Slf4j
public class UrlCode {
    private String urlEnCode;
    private String urlCode;

    /**
     * url编码
     * @param s 需要编码的url
     * @return 编码后的url
     */
    public String urlEncoding(String s){
        try {
            //编码
            urlEnCode = URLEncoder.encode(s.toString(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        log.info("url编码后：{}",urlEnCode);
        return urlEnCode;
    }

    /**
     * url解码
     * @param s 需要解码的url
     * @return 解码后的url
     */
    public String urlCode(String s){
        try {
            urlCode = URLDecoder.decode(s,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        log.info("url解码后：{}",urlCode);
        return urlCode;
    }
}
