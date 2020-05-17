package com.example.security.interceptor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LogUrlInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            System.out.println("请求 ： " + request.getRequestURL().toString());
            Map<String, String> userMap = new HashMap<>();
            userMap.put("u1", "u1");
            userMap.put("u2", "u2");
            Map<String, List<String>> roleMap = new HashMap<>();
            roleMap.put("u1", Arrays.asList("user", "test"));
            roleMap.put("u2", Arrays.asList("test"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String s = userMap.get(username);
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user");
//                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("u1", "u1", Arrays.asList(grantedAuthority));
//                SecurityContextHolder.getContext().setAuthentication(token);

       // }

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority g : authorities) {
            System.out.println("授权 ： " + g.getAuthority());
        }
        /**
         * getAuthorities()，权限信息列表，默认是GrantedAuthority接口的一些实现类，通常是代表权限信息的一系列字符串。
         * getCredentials()，密码信息，用户输入的密码字符串，在认证过后通常会被移除，用于保障安全。
         * getDetails()，细节信息，web应用中的实现接口通常为 WebAuthenticationDetails，它记录了访问者的ip地址和sessionId的值。
         * getPrincipal()，最重要的身份信息，大部分情况下返回的是UserDetails接口的实现类，也是框架中的常用接口之一。
         */
//        Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();
//        System.out.println("credentials is : " + credentials.toString());
//        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        System.out.println("details : " + details.toString());
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("principal : " + principal.toString());
    }
    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {
    }

}
