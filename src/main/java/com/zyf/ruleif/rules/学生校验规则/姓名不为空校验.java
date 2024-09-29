package com.zyf.ruleif.rules.学生校验规则;

import com.zyf.ruleif.base.AbstractRule;
import com.zyf.ruleif.entity.学生;

public class 姓名不为空校验 extends AbstractRule<学生> {

    @Override
    public boolean execute(学生 t) {
        return t.get姓名() != null && !"".equals(t.get姓名());
    }
}
