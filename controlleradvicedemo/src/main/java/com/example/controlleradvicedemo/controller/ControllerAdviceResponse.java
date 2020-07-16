package com.example.controlleradvicedemo.controller;

import com.example.controlleradvicedemo.Entity.CommonJsonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;


/**
 * @author cuiyaocy
 */

@RestControllerAdvice
public class ControllerAdviceResponse implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method = methodParameter.getMethod();
        if (method == null) {
            System.out.println("null");
            return false;
        }
        if (method.getReturnType().equals(CommonJsonResponse.class)) {
            System.out.println("CommonJsonResponse 不通过");
            return false;
        }
        System.out.println(methodParameter.toString());
        System.out.println(method);
        System.out.println(method.getReturnType());
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println("obj is : " + o);
        CommonJsonResponse res = new CommonJsonResponse(HttpStatus.OK.value(), 200);
        res.setData(o);
        return res;
    }
}
