package com.example.qrcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public Object greet() {
        System.out.println("我咋這來");
        return "hello";
    }

    @GetMapping("/")
    public Object get(@RequestParam("name") String name, @RequestParam("userId") List<String> userIds) {
        System.out.println("name is : " + name);
        System.out.println("ids is : " + userIds);
        return userIds;
    }

    @GetMapping("/exception")
    public Object get() {
        System.out.println("我咋這來");
        int a = 2 / 0;
        return "hello";
    }
}
