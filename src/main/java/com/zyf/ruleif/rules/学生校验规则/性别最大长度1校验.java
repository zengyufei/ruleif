package com.zyf.ruleif.rules.学生校验规则;

import com.zyf.ruleif.base.AbstractRule;
import com.zyf.ruleif.entity.学生;

public class 性别最大长度1校验 extends AbstractRule<学生> {

    @Override
    public boolean execute(学生 t) {
        return t.get性别().length() == 1;
    }
}
