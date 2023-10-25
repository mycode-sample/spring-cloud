package com.wrotecode.spring.springcloud.cp6.sc2.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class NamespaceConfigDemo implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    @NacosValue(value = "${menuPrefix:default-menuPrefix}", autoRefreshed = true)
    private String menuPrefix;

    public void printConfig() {
        System.out.println("--->获取上下文环境NamespaceConfigDemo:");
        String prefix = applicationContext.getEnvironment().getProperty("menuPrefix");
        System.out.println("prefix -> " + prefix);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("菜单前缀:" + menuPrefix);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
