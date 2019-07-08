package com.tabcorp.betsapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    //Creating 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}pass123").roles("USER")
                .and()
                .withUser("admin").password("{noop}pass456").roles("USER", "ADMIN");

    }

    // Secure the endpoints with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        // HTTP Basic authentication
        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/bets").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/bets").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/reports/investment/bt/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/reports/investment/cust/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/reports/sold/**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}

