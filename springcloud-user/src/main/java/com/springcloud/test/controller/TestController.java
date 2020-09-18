package com.springcloud.test.controller;

import com.springcloud.test.api.OauthServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class TestController {

    @Resource
    private OauthServiceApi oauthServiceApi;

    @GetMapping("/login")
    public String test(){
         oauthServiceApi.getToken();
         return "hahaha";
    }
}
