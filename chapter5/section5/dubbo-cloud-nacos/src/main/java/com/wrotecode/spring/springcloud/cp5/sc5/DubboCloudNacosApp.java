package com.wrotecode.spring.springcloud.cp5.sc5;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class DubboCloudNacosApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboCloudNacosApp.class, args);
    }
}
