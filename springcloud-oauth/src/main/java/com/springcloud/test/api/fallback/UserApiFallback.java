package com.springcloud.test.api.fallback;

import com.springcloud.test.api.UserApi;

public class UserApiFallback implements UserApi {
    @Override
    public String test() {
        return "已经熔断了";
    }
}
