package com.example.reggie.customException;

import com.example.reggie.domin.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.reggie.domin.ResponseCode.REQUEST_ERR;

//@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class ProjectExceptionAdvice {
    //拦截自定义系统异常
    @ExceptionHandler(SystemException.class)
    public ResponseData toSystemException(SystemException systemException){
        log.error(systemException.getMessage(),systemException);
        return new ResponseData(systemException.getCode(), systemException.getMessage());
    }
    //拦截自定义用户操作异常
    @ExceptionHandler(BusinessException.class)
    public ResponseData toBusinessException(BusinessException businessException){
        log.error(businessException.getMessage(),businessException);
        return new ResponseData(businessException.getCode(), businessException.getMessage());
    }
    //拦截系统异常
    @ExceptionHandler(Exception.class)
    public ResponseData toException(Exception e){
        log.error(e.getMessage(),e);
        return new ResponseData(REQUEST_ERR,"出错啦");
    }
}
