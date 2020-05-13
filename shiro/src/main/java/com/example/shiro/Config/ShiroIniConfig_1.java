package com.example.shiro.Config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroIniConfig_1 {

//    @Bean("securityManager")
//    @ConditionalOnMissingBean
//    public SecurityManager securityManager() {
//        //1.
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//
//        //2.
//        SecurityManager securityManager = factory.getInstance();
//
//        //3.
//        SecurityUtils.setSecurityManager(securityManager);
//
//        return securityManager;
//    }
}
