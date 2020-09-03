package com.example.resilience4jdemo.controller;

import com.example.resilience4jdemo.service.IFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @Autowired
    IFeignClient feignClient;

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public Object greeting() {
        System.out.println("進入方法了");
        return feignClient.getGreeting();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/greeting1")
    public Object get() {
        System.out.println("進入方法了");
        return feignClient.getGreetingException();
    }
}
