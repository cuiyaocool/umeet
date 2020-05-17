package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author cuiyaocy
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthorizationProvider provider;
    @Autowired
    MyCustomAuthorizationProvider myCustomAuthorizationProvider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.authenticationProvider(provider);
        auth.authenticationProvider(myCustomAuthorizationProvider);
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
	    return super.userDetailsServiceBean();
	 }

	 @Override
     protected void configure(HttpSecurity http) throws Exception {
         //配置例子： https://www.cnblogs.com/zimug/p/11870861.html
         // 登录成功跳转 302 解决 https://blog.csdn.net/qq_33928083/article/details/89367589
         MyCustomFilter filter = new MyCustomFilter("/logincustom");
         http.csrf().disable()
                 .authorizeRequests()
                 .antMatchers("/", "/index", "/static/**").permitAll()
                 .antMatchers("/user").hasRole("user")
                 .antMatchers("/test").hasAnyRole("user", "test")
                 .antMatchers("/security").authenticated()
                 .antMatchers("/dashboard").denyAll()
                 .anyRequest().authenticated()
                 .and()
                 .formLogin()
                 .loginPage("/page")
                 .loginProcessingUrl("/logincustom")
                 .defaultSuccessUrl("/index")
                 .permitAll()
                 .and()
                 .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                 .httpBasic();
     }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("user")
//                        .build();
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("tester")
//                .password("tester")
//                .roles("test")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, user1);
//    }
}

