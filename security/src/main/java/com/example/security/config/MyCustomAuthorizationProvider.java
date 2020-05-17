package com.example.security.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyCustomAuthorizationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("MyCustomAuthorizationProvider 开始认证");
        String name = (String) authentication.getPrincipal();
        System.out.println("name is : " + name);
        MyUsernamePasswordAuthenticationToken token = (MyUsernamePasswordAuthenticationToken)authentication;
        UserDetails userDetails = new MyUserDetail();
        if (name.equals("u")) {
            ((MyUserDetail) userDetails).setMyName("u");
            ((MyUserDetail) userDetails).setPw("u");
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_user"));
            authorities.add(new SimpleGrantedAuthority("ROLE_test"));
            ((MyUserDetail) userDetails).setAuthorities(authorities);
            System.out.println("发现user用户");
        } else if (name.equals("t")) {
            ((MyUserDetail) userDetails).setMyName("t");
            ((MyUserDetail) userDetails).setPw("t");
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_test"));
            ((MyUserDetail) userDetails).setAuthorities(authorities);
            System.out.println("发现test用户");
        } else {
            System.out.println("未发现用户");
            return null;
        }
        authentication = new MyUsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        System.out.println("自定义provider支持的token验证");
        return MyUsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
