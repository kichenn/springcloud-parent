package com.hzit.hystrixDashboard.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.hzit.hystrixDashboard.api")
@ComponentScan(basePackages = {"com.hzit.hystrixDashboard.api","com.hzit.hystrixDashboard.consumer"})
public class ConsumerApplicaion {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicaion.class,args);
    }
}
