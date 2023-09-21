package com.wrotecode.spring.springcloud.userservice;

public class UserProvider implements UserApi {
    @Override
    public String getNameById(String id) {
        System.out.println("请求id:" + id);
        return "用户名:" + id;
    }
}
