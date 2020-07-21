package com.springcloud.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/oauth/test")
    public String test(){
        return "Hello world";
    }
}
