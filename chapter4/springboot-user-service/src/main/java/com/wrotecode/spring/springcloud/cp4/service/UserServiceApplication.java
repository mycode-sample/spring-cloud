package com.wrotecode.spring.springcloud.cp4.service;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class UserServiceApplication  {
    public static void main(String[] args)throws Exception {
        SpringApplication.run(UserServiceApplication.class);
    }
}
