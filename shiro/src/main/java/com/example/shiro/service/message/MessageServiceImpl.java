package com.example.shiro.service.message;

import com.example.shiro.service.IMessageService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("messageServiceImpl")
public class MessageServiceImpl implements IMessageService {

    @Override
    public Object getMessage() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            if (subject.isPermitted("winnebago:drive:eagle5")) {
                return "success Message";
            }
        }
        return "fail";
    }
}
