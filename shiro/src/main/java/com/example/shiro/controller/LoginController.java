package com.example.shiro.controller;

import com.example.shiro.service.loginService.LoginServiceImpl;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String login(@RequestParam String username, @RequestParam String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        loginService.login(token);
        return "redirect:/api/login/suc";
    }

    @RequestMapping("/suc")
    public Object suc() {
        return "suc page";
    }

    @RequestMapping("fail")
    public Object fail() {
        return "fail page";
    }
}
