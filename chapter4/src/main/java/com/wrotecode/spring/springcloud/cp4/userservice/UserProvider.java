package com.wrotecode.spring.springcloud.cp4.userservice;

public class UserProvider implements UserApi {
    @Override
    public String getNameById(String id) {
        String host = System.getProperty("host");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("请求实例:%s, 请求参数: %s%n", host, id);
        return String.format("实例:%s, 用户标识:%s", host, id);
    }
}
