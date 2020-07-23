package com.springcloud.test.service.impl;

import com.springcloud.test.api.UserApi;
import com.springcloud.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private UserApi userApi;

    @Override
    public String test() {
        return userApi.test();
    }
}
