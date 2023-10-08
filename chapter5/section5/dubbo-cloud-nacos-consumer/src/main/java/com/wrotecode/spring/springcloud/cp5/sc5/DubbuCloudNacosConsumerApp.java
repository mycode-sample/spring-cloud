package com.wrotecode.spring.springcloud.cp5.sc5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DubbuCloudNacosConsumerApp {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(DubbuCloudNacosConsumerApp.class, args);
        DubboService service = context.getBean(DubboService.class);
        service.work();
    }
}
