package com.wrotecode.spring.springcloud.cp4.orderservice;

import com.wrotecode.spring.springcloud.cp4.userservice.UserApi;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;

public class OrderServiceApp {
    public static void main(String[] args) throws Exception{
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:consumer.xml");
        context.refresh();
        UserApi userApi = context.getBean(UserApi.class);
        while (true) {
            System.out.println(userApi.getNameById(new Date().toString()));
            Thread.sleep(500);
        }
    }
}
