package com.wrotecode.springcloud.cp5.sc2.nacosspringboot;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class NacosApplication {
    public static void main(String[] args) throws NacosException {
        ConfigurableApplicationContext context = SpringApplication.run(NacosApplication.class);
        NacosComponent demo = context.getBean(NacosComponent.class);
        String name = "nacos-service";
        String ip = "localhost";
        int port = 3000;
        demo.register(name, ip, port);
        List<Instance> list = demo.discovery(name);
        System.out.println(list);
    }
}
