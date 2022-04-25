package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        UserBuilder user=User.withDefaultPasswordEncoder();
       // auth.inMemoryAuthentication().withUser("c1s").password("{noop}cs").roles("EMPLOYEE").and()
         //       .withUser("manager").password("{noop}cs").roles("EMPLOYEE,MANAGER").and()
          //      .withUser("abcd").password("{noop}cs").roles("EMPLOYEE,MANAGER");
        auth.inMemoryAuthentication().withUser(user.username("abcd").roles("EMPLOYEE").password("cs"))
                .withUser(user.username("a").roles("EMPLOYEE","MANAGER").password("cs"))
                .withUser(user.username("aa").roles("EMPLOYEE","ADMIN").password("cs"));



    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")

                .antMatchers("/leaders/**").hasAnyRole("MANAGER","ADMIN")




                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

    }
}
