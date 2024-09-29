package com.zyf.ruleif.rules.学生校验规则;

import com.zyf.ruleif.base.AbstractRule;
import com.zyf.ruleif.entity.学生;

import java.util.Arrays;

public class 性别范围校验 extends AbstractRule<学生> {

    @Override
    public boolean execute(学生 t) {
        return Arrays.asList("男", "女").contains(t.get性别());
    }
}
