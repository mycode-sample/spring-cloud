package com.wrotecode.spring.springcloud.cp4;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class OrderServiceApplication {
    @Reference
    private UserService service;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(OrderServiceApplication.class);
        System.out.println(context);
        OrderServiceApplication app = context.getBean(OrderServiceApplication.class);
        while (true) {
            System.out.println(app.service.getNameById(new Date().toString()));
            Thread.sleep(1000);
        }
    }
}
