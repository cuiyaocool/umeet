package com.example.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyCustomFilter extends AbstractAuthenticationProcessingFilter {

    private String defaultFilterProcessesUrl;
    protected MyCustomFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        System.out.println("自定义filter");
        String myUserNme = httpServletRequest.getParameter("username");
        System.out.println("收到信息 ： " + myUserNme);
        return new MyUsernamePasswordAuthenticationToken(myUserNme);
    }
}
