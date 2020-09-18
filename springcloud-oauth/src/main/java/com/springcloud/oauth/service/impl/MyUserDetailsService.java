package com.springcloud.oauth.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Collection<SimpleGrantedAuthority> collection = new HashSet<>();
        collection.add(new SimpleGrantedAuthority("测试"));
        return new User("admin","123456",collection);

        //用户不存在抛出该异常
        //throw new UsernameNotFoundException("");
    }
}
