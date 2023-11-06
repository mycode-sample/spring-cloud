package com.wrotecode.spring.springcloud.cp7.sc1;

public class SentinelDemo {
    public static void main(String[] args)  {
        Thread t1 = new Thread(new WorkExecutor("doWork"));
        t1.start();
        Thread t2 = new Thread(new WorkExecutor("work2"));
        t2.start();
        Thread t3 = new Thread(new WorkExecutor("work3"));
        t3.start();
        Thread t4 = new Thread(new WorkExecutor("work4"));
        t4.start();
    }
}
