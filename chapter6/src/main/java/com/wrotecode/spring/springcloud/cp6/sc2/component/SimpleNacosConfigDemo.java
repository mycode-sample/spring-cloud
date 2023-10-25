package com.wrotecode.spring.springcloud.cp6.sc2.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SimpleNacosConfigDemo implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static final String[] keys = {"url", "driver", "username", "password"};

    @NacosValue(value = "${url:defaultUrl}", autoRefreshed = true)
    private String url;
    @NacosValue(value = "${driver:defaultDriver}", autoRefreshed = true)
    private String driver;
    @NacosValue(value = "${username:defaultUserName}", autoRefreshed = true)
    private String username;
    @NacosValue(value = "${password:123456}", autoRefreshed = true)
    private String password;

    public void printConfig() {
        System.out.println("--->获取上下文环境SimpleNacosConfigDemo:");
        Environment environment = applicationContext.getEnvironment();
        for (String key : keys) {
            System.out.printf("%s -> %s\n", key, environment.getProperty(key));
        }
    }

    @Override
    public void afterPropertiesSet() {
        System.out.printf("--->\n数据库连接:%s\n驱动:%s\n用户名: %s\n密码: %s\n", url, driver, username, password);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
