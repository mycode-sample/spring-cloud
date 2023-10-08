package com.wrotecode.spring.springcloud.cp5.sc5;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class DubboService {
    @Reference
    private HelloService helloService;

    public void work() throws Exception {
        int i = 0;
        while (true) {
            String name = helloService.sayHello(Integer.toString(i++));
            System.out.println(name);
            Thread.sleep(1000);
        }
    }
}
