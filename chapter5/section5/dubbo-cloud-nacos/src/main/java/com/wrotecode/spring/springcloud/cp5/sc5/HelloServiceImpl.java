package com.wrotecode.spring.springcloud.cp5.sc5;

import org.apache.dubbo.config.annotation.Service;

import java.util.Date;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return String.format("hello,%s,now is %s", name, new Date());
    }
}
