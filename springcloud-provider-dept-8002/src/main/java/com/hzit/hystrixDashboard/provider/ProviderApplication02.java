package com.hzit.hystrixDashboard.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@MapperScan("com.hzit.hystrixDashboard.provider.mapper")
@EnableEurekaClient
@EnableCircuitBreaker //服务熔断
@EnableHystrix
@EnableHystrixDashboard
public class ProviderApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication02.class,args);
    }
}
