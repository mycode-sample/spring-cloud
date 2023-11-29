package com.wrotecode.spring.springcloud.cp7.sc1;

import java.util.Random;

public class DegradeApp {
    public static void main(String[] args) throws Exception {
        DegradeBusinessWork work = new DegradeBusinessWork();
        work.init();
        Random random = new Random();
        while (true) {
            work.work();
            Thread.sleep(sleep(random));
        }
    }

    public static long sleep(Random random) {
        long l = random.nextInt(1000);
        while (l > 500) {
            l = random.nextInt(1000);
        }
        return l;
    }
}
