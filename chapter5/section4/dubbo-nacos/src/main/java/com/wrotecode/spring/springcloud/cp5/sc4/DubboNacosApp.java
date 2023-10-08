package com.wrotecode.spring.springcloud.cp5.sc4;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan
@SpringBootApplication
public class DubboNacosApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboNacosApp.class);
    }
}
