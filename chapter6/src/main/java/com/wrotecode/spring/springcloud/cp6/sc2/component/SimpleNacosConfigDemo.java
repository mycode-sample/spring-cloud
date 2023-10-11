package com.wrotecode.spring.springcloud.cp6.sc2.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Component;

@Component
public class SimpleNacosConfigDemo {

    @NacosValue(value = "${url:defaultUrl}", autoRefreshed = true)
    private String url;
    @NacosValue(value = "${driver:defaultDriver}", autoRefreshed = true)
    private String driver;
    @NacosValue(value = "${username:defaultUserName}", autoRefreshed = true)
    private String username;
    @NacosValue(value = "${password:123456}", autoRefreshed = true)
    private String password;

    public void printConfig() {
        System.out.printf("--->数据库连接:%s\n驱动:%s\n用户名: %s\n密码: %s\n", url, driver, username, password);
    }
}
