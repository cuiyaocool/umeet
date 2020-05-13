package com.example.shiro.controller;

import com.example.shiro.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/msg")
public class MessageController {

    @Autowired
    @Qualifier("messageServiceImpl")
    IMessageService messageService;

    @GetMapping("/list")
    public Object getMessage() {
        return messageService.getMessage();
    }

    @GetMapping("/previlige/no")
    public Object previligeNo() {
        return "previlige_no_page!";
    }

    @GetMapping("/anon")
    public Object anon() {
        return "anon page";
    }

    @GetMapping("/role")
    public Object role() {
        return "role page";
    }

    @GetMapping("/perms")
    public Object perms() {
        return "perms page";
    }
}
