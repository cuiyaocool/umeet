package com.example.controlleradvicedemo.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonJsonResponse<T> {

    private int status;
    /**
     * 0 means success
     */
    private int errorCode;

    /**
     * SUCCESS or others
     */
    private String msg;

    /**
     * the result data, may user info or others
     */
    private T data;

    public CommonJsonResponse() {
    }

    public  CommonJsonResponse(int status, int errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public CommonJsonResponse(int status, int errorCode, String msg) {
        this.status = status;
        this.errorCode = errorCode;
        this.msg = msg;
    }
}
