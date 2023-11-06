package com.wrotecode.spring.springcloud.cp7.sc1;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
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
        FlowRule rule2 = new FlowRule();
        rule2.setResource("work2");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1);
        rules.add(rule2);
        FlowRuleManager.loadRules(rules);
    }

    public void doWork() {
        try (Entry entry = SphU.entry("business")) {
            System.out.println("business -> 开始执行业务");
        } catch (BlockException e) {
            System.out.println("business -> 业务过多，被限流");
            e.printStackTrace();
        }

    }

    public void work2() {
        if (SphO.entry("work2")) {
            try {
                System.out.println("work2 -> 执行工作2");
            } finally {
                SphO.exit();
            }
        } else {
            System.out.println("work2 -> 超过阈值，禁止访问");
        }
    }
}
