package com.wrotecode.spring.springcloud.cp6.sc2.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NacosPropertySource(dataId = "nacos-config-demo", autoRefreshed = true)
public class SimpleNacosConfigDemo {
    @NacosValue(value = "${info:hello,world}", autoRefreshed = true)
    private String info;

    public void printConfig() {
        System.out.printf("%s -> %s%n", new Date(), info);
    }
}
