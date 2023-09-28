package com.wrotecode.spring.springcloud.cp4.service;

public class DefaultUserServiceImpl implements UserService{
    @Override
    public String getNameById(String id) {
        return "出现异常。当前参数:" + id;
    }
}
