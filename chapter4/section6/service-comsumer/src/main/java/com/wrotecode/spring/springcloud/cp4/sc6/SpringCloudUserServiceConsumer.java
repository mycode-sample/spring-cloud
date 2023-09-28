package com.wrotecode.spring.springcloud.cp4.sc6;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class SpringCloudUserServiceConsumer {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringCloudUserServiceConsumer.class, args);
        UserServiceApi api = ctx.getBean(UserServiceApi.class);
        while (true) {
            api.getNameById(new Date().toString());
            Thread.sleep(1000);
        }
    }
}
