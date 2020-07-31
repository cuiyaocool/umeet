package com.example.controlleradvicedemo.controller;

import com.example.controlleradvicedemo.Entity.User;
import com.example.controlleradvicedemo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiyaocy
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public Object getUser() {
        return userService.getUser();
    }

    @GetMapping("/err")
    public Object throwException() throws Exception {
        return userService.throwException();
    }

    @GetMapping("/showLog")
    public Object outputLog() {
        log.trace("trace log");
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");
        log.error("error log");
        return "logs";
    }
}
