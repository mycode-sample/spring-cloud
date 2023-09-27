package com.wrotecode.spring.springcloud.cp4.sc6;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan
@SpringBootApplication
public class SpringCloudUserServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserServiceApp.class, args);
    }
}
