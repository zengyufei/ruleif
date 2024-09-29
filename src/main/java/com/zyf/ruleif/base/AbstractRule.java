package com.zyf.ruleif.base;


// 规则模板
public abstract class AbstractRule<T> implements BaseRule<T> {

    @Override
    public boolean execute(T t) {
        return executeRule(convert(t));
    }

    protected <S> S convert(T t) {
        return (S) t;
    }

    protected <S> boolean executeRule(S s) {
        return true;
    }
}
