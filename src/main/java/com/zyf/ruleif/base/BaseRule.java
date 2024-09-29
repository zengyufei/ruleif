package com.zyf.ruleif.base;


// 规则抽象
public interface BaseRule<T> {

    boolean execute(T t);
}
