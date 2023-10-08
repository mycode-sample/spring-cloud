package com.wrotecode.spring.springcloud.cp5.sc4;

import com.wrotecode.spring.springcloud.cp4.sc6.UserServiceApi;
import org.apache.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserServiceApi {
    @Override
    public String getNameById(String id) {
        System.out.println("获取用户名，当前id:" + id);
        return "id对应的用户名是：dubbo用户~" + id;
    }
}
