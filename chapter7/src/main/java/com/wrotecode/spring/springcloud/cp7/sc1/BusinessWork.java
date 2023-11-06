package com.wrotecode.spring.springcloud.cp7.sc1;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
        rule.setCount(0.5);
        rules.add(rule);

        FlowRule rule2 = new FlowRule();
        rule2.setResource("work2");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(0.5);
        rules.add(rule2);

        FlowRule rule3 = new FlowRule();
        rule3.setResource("work3");
        rule3.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule3.setCount(0.5);
        rules.add(rule3);

        FlowRule rule4 = new FlowRule();
        rule4.setResource("work4");
        rule4.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule4.setCount(0.5);
        rules.add(rule4);

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

    @SentinelResource(value = "work3", blockHandler = "handleBlockException")
    public void work3() {
        System.out.println("work3 -> 开始执行业务");
    }

    public void handleBlockException(BlockException e) {
        System.out.println("***>使用本地方法处理拦截异常<***");
        e.printStackTrace();
    }

    @SentinelResource(value = "work4", blockHandler = "handleBlockException", blockHandlerClass = BlockHandler.class)
    public void work4() {
        System.out.println("work4 -> 开始执行业务");
    }
}
