package com.springcloud.test.api;

import com.springcloud.test.api.fallback.UserApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "springcloud-user",fallback = UserApiFallback.class)
public interface UserApi {

    @GetMapping("/user/test")
    String test();
}
