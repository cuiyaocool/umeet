package com.example.controlleradvicedemo.controller;

import com.example.controlleradvicedemo.Entity.User;
import com.example.controlleradvicedemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiyaocy
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public Object getUser() {
        return userService.getUser();
    }

    @GetMapping("/error")
    public Object throwException() throws Exception {
        return userService.throwException();
    }
}
