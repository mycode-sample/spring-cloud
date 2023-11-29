package com.wrotecode.spring.springcloud.cp7.sc1;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DegradeBusinessWork {

    public void init() {
        DegradeRule rule = new DegradeRule();
        rule.setResource("work");
        rule.setCount(10);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setTimeWindow(10);
        rule.setMinRequestAmount(5);
        List<DegradeRule> list = new ArrayList<>();
        list.add(rule);
    }

    public void work() {
        SimpleDateFormat format = new SimpleDateFormat();
        try (Entry entry = SphU.entry("work")) {
            System.out.println("开始执行业务:" + format.format(System.currentTimeMillis()));
        } catch (Exception e) {
            System.out.println("超过阈值，开始熔断");
            e.printStackTrace();
        }
    }
}
