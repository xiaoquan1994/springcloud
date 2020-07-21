package com.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableHystrix//开启熔断,已经在配置文件中添加了熔断配置，此处不用添加注解了
@EnableFeignClients//开启openfeign声明式远程调用
@EnableDiscoveryClient//开启eureka服务注册信息
@SpringBootApplication//spring boot的启动类
public class SpringCloudOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOauthApplication.class, args);
    }
}
