package com.zyf.ruleif.rules.学生校验规则;

import com.zyf.ruleif.base.AbstractRule;
import com.zyf.ruleif.entity.学生;

public class 姓名长度大于1校验 extends AbstractRule<学生> {

    @Override
    public boolean execute(学生 t) {
        return t.get姓名().length() > 1;
    }
}
