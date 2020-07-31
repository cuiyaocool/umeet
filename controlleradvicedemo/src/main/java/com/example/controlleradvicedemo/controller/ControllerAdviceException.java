package com.example.controlleradvicedemo.controller;

import com.example.controlleradvicedemo.Entity.CommonJsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cuiyaocy
 */

@RestControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(Exception.class)
    public CommonJsonResponse customException(Exception e) {
        e.printStackTrace();
        System.out.println("e : " + e.getMessage());
        CommonJsonResponse res = new CommonJsonResponse(HttpStatus.OK.value(), 200);
        return res;
    }
}
