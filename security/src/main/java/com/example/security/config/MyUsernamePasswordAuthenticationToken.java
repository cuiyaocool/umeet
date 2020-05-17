package com.example.security.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MyUsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {

    private String myUserName;
    private String pw;

    public MyUsernamePasswordAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public MyUsernamePasswordAuthenticationToken(String myUserName) {
        super(null);
        this.myUserName = myUserName;
        this.setAuthenticated(false);
        System.out.println("生成未认证token");
    }

    public MyUsernamePasswordAuthenticationToken(String myUserName, String pw, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.myUserName = myUserName;
        this.pw = pw;
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return pw;
    }

    @Override
    public Object getPrincipal() {
        return myUserName;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
