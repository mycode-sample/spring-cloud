package com.wrotecode.spring.springcloud.cp7.sc1;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockHandler {
    public static void handleBlockException(BlockException e) {
        System.out.println("--->使用额外方法处理拦截异常<---");
        e.printStackTrace();
    }
}
