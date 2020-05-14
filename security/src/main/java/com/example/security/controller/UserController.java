package com.example.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiyaocy
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public Object user() {
        return "only user role can view user page";
    }
}
