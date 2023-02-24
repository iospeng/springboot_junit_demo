package com.example.reggie.customException;

public class BusinessException extends RuntimeException{
    private int code;

    public BusinessException(int code) {
        this.code = code;
    }

    public BusinessException(int code,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(int code,Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BusinessException(int code,String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
