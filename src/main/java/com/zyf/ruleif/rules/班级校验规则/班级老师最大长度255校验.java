package com.zyf.ruleif.rules.班级校验规则;

import com.zyf.ruleif.base.AbstractRule;
import com.zyf.ruleif.entity.班级;

public class 班级老师最大长度255校验 extends AbstractRule<班级> {

    @Override
    public boolean execute(班级 t) {
        if (t.get班级老师() == null) {
            return true;
        }
        return t.get班级老师().length() <= 255;
    }

}
