package com.wrotecode.spring.springcloud.cp7.sc1;

import java.util.Random;

public class SentinelDemo {
    public static void main(String[] args) throws Exception {
        BusinessWork work = new BusinessWork();
        Random random = new Random();
        while (true) {
            work.doWork();
            long t = random.nextInt(1000);
            while (t < 500) {
                t = random.nextInt(1000);
            }
            System.out.println("t ->" + t);
            Thread.sleep(t);
        }
    }
}
