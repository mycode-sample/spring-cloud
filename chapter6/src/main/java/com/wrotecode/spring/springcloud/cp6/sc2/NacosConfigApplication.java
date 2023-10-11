package com.wrotecode.spring.springcloud.cp6.sc2;

import com.wrotecode.spring.springcloud.cp6.sc2.component.SimpleNacosConfigDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NacosConfigApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(NacosConfigApplication.class);
        SimpleNacosConfigDemo demo = context.getBean(SimpleNacosConfigDemo.class);
        while (true) {
            demo.printConfig();
            System.out.println(context.getEnvironment().getProperty("driver"));
            Thread.sleep(1000);
        }
    }
}
