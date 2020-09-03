package com.example.resilience4jdemo.service;

import feign.RequestLine;

public interface IFeignClient {
    @RequestLine("GET /greeting")
    public String getGreeting();

    @RequestLine("POST /greeting")
    public String createGreeting();

    @RequestLine("POST /exception")
    public String getGreetingException();
}
