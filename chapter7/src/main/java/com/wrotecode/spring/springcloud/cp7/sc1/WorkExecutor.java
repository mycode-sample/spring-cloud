package com.wrotecode.spring.springcloud.cp7.sc1;

import java.lang.reflect.Method;
import java.util.Random;

public class WorkExecutor implements Runnable {
    private Random random = new Random();
    private String methodName;
    private BusinessWork businessWork = new BusinessWork();
    private int minSleep = 50;
    private int maxSleep = 1000;

    public WorkExecutor(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public void run() {
        Method method = null;
        try {
            method = BusinessWork.class.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                method.invoke(businessWork);
                long t = random.nextInt(maxSleep);
                while (t < minSleep || t > maxSleep) {
                    t = random.nextInt(maxSleep);
                }
                Thread.sleep(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public WorkExecutor setMinSleep(int minSleep) {
        this.minSleep = minSleep;
        return this;
    }

    public WorkExecutor setMaxSleep(int maxSleep) {
        this.maxSleep = maxSleep;
        return this;
    }
}
