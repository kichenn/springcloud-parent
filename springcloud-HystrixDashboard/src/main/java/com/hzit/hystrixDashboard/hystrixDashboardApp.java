package com.hzit.hystrixDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class hystrixDashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(hystrixDashboardApp.class,args);
    }
}
