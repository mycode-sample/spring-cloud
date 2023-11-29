package com.wrotecode.spring.springcloud.cp7.sc1;

public class DegradeApp {
    public static void main(String[] args) throws Exception{
        DegradeBusinessWork work = new DegradeBusinessWork();
        work.init();
        while (true) {
            work.work();
            work.work();
        }
    }
}
