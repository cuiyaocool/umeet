package com.example.shiro.service.loginService;

import com.example.shiro.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    public void login(UsernamePasswordToken token) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        Session session = subject.getSession();
        session.setAttribute("shiroSavedRequest", null);
    }
}
