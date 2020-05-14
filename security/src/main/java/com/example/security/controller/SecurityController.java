package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiyaocy
 */
@Controller
public class SecurityController {
    @RequestMapping("/security")
    @ResponseBody
    public Object security() {
        return "you are security man";
    }

    @RequestMapping("/dashboard")
    @ResponseBody
    public Object dastboard() {
        return "deny";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public Object login() {
//        return "kdkdk.htm";
//    }
    @RequestMapping("/suc")
    @ResponseBody
    public Object loginSuc() {
        return "login success";
    }

    @ResponseBody
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@RequestParam("username") String username,
                         @RequestParam("password") String password) {

        if ("error@1.1".equalsIgnoreCase(username)) {
            return "error";
        } else {
            return "demo";
        }
    }

}
