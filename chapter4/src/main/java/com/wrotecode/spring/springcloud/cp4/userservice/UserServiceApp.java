package com.wrotecode.spring.springcloud.cp4.userservice;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;

public class UserServiceApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        String host = System.getProperty("host");
        if (host != null) {
            context.load(String.format("classpath:user-provider-%s.xml", host));
        } else {
            context.load("classpath:user-provider.xml");
        }
        context.refresh();
        System.out.println(context);
        System.out.printf("实例%s已启动%n", System.getProperty("host"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            System.out.println(input);
        }
    }
}
