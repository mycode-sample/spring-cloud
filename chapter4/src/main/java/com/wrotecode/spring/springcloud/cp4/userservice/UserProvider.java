package com.wrotecode.spring.springcloud.cp4.userservice;

public class UserProvider implements UserApi {
    @Override
    public String getNameById(String id) {
        System.out.println("请求id:" + id);
        return "用户名:" + id;
    }
}
