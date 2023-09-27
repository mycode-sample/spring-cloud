package com.wrotecode.spring.springcloud.cp4.sc6;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class UserServiceApiImpl implements UserServiceApi {
    @Value("${dubbo.application.name}")
    private String appName;

    @Override
    public String getNameById(String id) {
        System.out.println("当前id:" + id);
        System.out.println("应用名称:" + appName);
        return String.format("需要查找的用户id%s,对应的用户是%s", id, id);
    }
}
