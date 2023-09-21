package com.wrotecode.spring.springcloud.userservice;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;

public class UserServiceApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:user-provider.xml");
        context.refresh();
        System.out.println(context);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            System.out.println(input);
        }
    }
}
