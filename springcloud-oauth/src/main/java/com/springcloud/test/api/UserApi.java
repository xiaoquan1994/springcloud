package com.springcloud.test.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "springcloud-user")
public interface UserApi {
    @GetMapping("/user/test")
    String test();
}
