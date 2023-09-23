package com.wrotecode.spring.springcloud.cp4;

import org.apache.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String getNameById(String id) {
        System.out.println("input:" + id);
        return "input is " + id;
    }
}
