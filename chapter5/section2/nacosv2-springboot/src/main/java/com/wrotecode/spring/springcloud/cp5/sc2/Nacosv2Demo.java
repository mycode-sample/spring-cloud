package com.wrotecode.spring.springcloud.cp5.sc2;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@NacosPropertySource(dataId = "demo", autoRefreshed = true)
@SpringBootApplication
public class Nacosv2Demo {


    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Nacosv2Demo.class);
        Nacosv2Component component = context.getBean(Nacosv2Component.class);
        while (true) {
            System.out.println(component.getUseLocalCache());
            Thread.sleep(1000);
        }
    }
}
