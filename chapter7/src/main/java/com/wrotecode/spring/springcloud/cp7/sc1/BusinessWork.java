package com.wrotecode.spring.springcloud.cp7.sc1;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class BusinessWork {

    public BusinessWork() {
        //设置限流规则
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("business");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    public void doWork() {
        try (Entry entry = SphU.entry("business")) {
            System.out.println("开始执行业务");
        } catch (BlockException e) {
            System.out.println("业务过多，被限流");
            e.printStackTrace();
        }

    }
}
