package com.springcloud.admin.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");

        http.authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .antMatchers( "/login").permitAll()
                .antMatchers( "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(successHandler)
                .and()
                .logout().logoutUrl("/logout").and()
                .httpBasic().and()
                .csrf().disable();
    }
}
