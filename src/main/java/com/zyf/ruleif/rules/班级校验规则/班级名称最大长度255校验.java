package com.zyf.ruleif.rules.班级校验规则;

import com.zyf.ruleif.base.AbstractRule;
import com.zyf.ruleif.entity.班级;

public class 班级名称最大长度255校验 extends AbstractRule<班级> {

    @Override
    public boolean execute(班级 t) {
        return t.get班级名称().length() <= 255;
    }

}
