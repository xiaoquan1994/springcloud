package com.springcloud.test.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "springcloud-oauth")
public interface OauthServiceApi {

    @PostMapping(value = "/oauth/token")
    Object getToken();

}
