package com.zyf.ruleif.base;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RuleService<T, R extends BaseRule<T>> {

    private final Map<Integer, List<R>> hashMap = new LinkedHashMap<>();
    private static final int AND = 1;
    private static final int OR = 0;

    public static <T, R extends BaseRule<T>> RuleService<T, R> create() {
        return new RuleService<>();
    }

    public RuleService<T, R> and(List<R> ruleList) {
        hashMap.computeIfAbsent(AND, k -> new ArrayList<>()).addAll(ruleList);
        return this;
    }

    public RuleService<T, R> or(List<R> ruleList) {
        hashMap.computeIfAbsent(OR, k -> new ArrayList<>()).addAll(ruleList);
        return this;
    }

    public boolean execute(T dto) {
        for (Map.Entry<Integer, List<R>> item : hashMap.entrySet()) {
            List<R> ruleList = item.getValue();
            switch (item.getKey()) {
                case AND -> {
                    // 如果是 and 关系，同步执行
//                    System.out.println("execute key = " + 1);
                    if (!and(dto, ruleList)) {
                        return false;
                    }
                }
                case OR -> {
                    // 如果是 or 关系，并行执行
//                    System.out.println("execute key = " + 0);
                    if (!or(dto, ruleList)) {
                        return false;
                    }
                }
                default -> {
                }
            }
        }
        return true;
    }

    private boolean and(T dto, List<R> ruleList) {
        for (R rule : ruleList) {
            boolean execute = rule.execute(dto);
            if (!execute) {
                System.out.println(rule.getClass().getName() + " 校验不通过!");
                // and 关系匹配失败一次，返回 false
                return false;
            }
        }
        // and 关系全部匹配成功，返回 true
        return true;
    }

    private boolean or(T dto, List<R> ruleList) {
        for (R rule : ruleList) {
            boolean execute = rule.execute(dto);
            if (execute) {
                // or 关系匹配到一个就返回 true
                return true;
            }
        }
        // or 关系一个都匹配不到就返回 false
        for (R r : ruleList) {
            System.out.println(r.getClass().getName() + " 校验不通过!");
        }
        return false;
    }
}
