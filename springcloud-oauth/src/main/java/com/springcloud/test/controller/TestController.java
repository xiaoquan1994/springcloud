package com.springcloud.test.controller;

import com.springcloud.test.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/oauth/test")
    public String test(){
        return testService.test();
    }
}
