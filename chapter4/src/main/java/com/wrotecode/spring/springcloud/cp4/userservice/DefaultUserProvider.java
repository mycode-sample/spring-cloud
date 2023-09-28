package com.wrotecode.spring.springcloud.cp4.userservice;

public class DefaultUserProvider implements UserApi{
    @Override
    public String getNameById(String id) {
        return "出现异常。当前参数:" + id;
    }
}
