package com.wrotecode.spring.springcloud.cp4;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@DubboComponentScan
public class UserServiceApplication  {
    public static void main(String[] args)throws Exception {
        SpringApplication.run(UserServiceApplication.class);
        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}
