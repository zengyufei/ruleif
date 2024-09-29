package com.zyf.ruleif;

import com.zyf.ruleif.base.BaseRule;
import com.zyf.ruleif.base.RuleService;
import com.zyf.ruleif.entity.班级;
import com.zyf.ruleif.rules.班级校验规则.*;

import java.util.Arrays;

public class Test班级 {

    static 班级人数不为空校验 班级人数不为空规则 = new 班级人数不为空校验();
    static 班级名称不为空校验 班级名称不为空规则 = new 班级名称不为空校验();
    static 班级名称最大长度255校验 班级名称最大长度255规则 = new 班级名称最大长度255校验();
    static 班级老师最大长度255校验 班级老师最大长度255规则 = new 班级老师最大长度255校验();
    static 班级人数最大值100校验 班级人数最大值100规则 = new 班级人数最大值100校验();


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        /*
         * 执行结果：
         * ==================== test1 begin =====================
         * test1 测试结果:true
         * ==================== test2 begin =====================
         * com.zyf.ruleif.rules.班级校验规则.班级人数不为空校验 校验不通过!
         * test2 测试结果:false
         * ==================== test3 begin =====================
         * com.zyf.ruleif.rules.班级校验规则.班级老师最大长度255校验 校验不通过!
         * com.zyf.ruleif.rules.班级校验规则.班级人数最大值100校验 校验不通过!
         * test2 测试结果:false
         * */
    }

    private static void test1() {
        System.out.println("==================== test1 begin =====================");

        final 班级 t = new 班级();
        t.set班级名称("三年级一班");
        t.set班级人数(10);
        t.set班级老师("武藤兰");


        //3. 通过以链式调用构建和执行 rule execute
        final RuleService<班级, BaseRule<班级>> base = RuleService.create();
        boolean ruleResult = base
                .and(Arrays.asList(班级人数不为空规则, 班级名称不为空规则))
                .and(Arrays.asList(班级名称最大长度255规则))
                .or(Arrays.asList(班级老师最大长度255规则, 班级人数最大值100规则))
                .execute(t);
        System.out.println("test1 测试结果:" + ruleResult);
    }

    private static void test2() {
        System.out.println("==================== test2 begin =====================");

        final 班级 t = new 班级();
        t.set班级名称("三年级一班");
        t.set班级人数(null);
        t.set班级老师("武藤兰");


        //3. 通过以链式调用构建和执行 rule execute
        final RuleService<班级, BaseRule<班级>> base = RuleService.create();
        boolean ruleResult = base
                .and(Arrays.asList(班级人数不为空规则, 班级名称不为空规则))
                .and(Arrays.asList(班级名称最大长度255规则))
                .or(Arrays.asList(班级老师最大长度255规则, 班级人数最大值100规则))
                .execute(t);
        System.out.println("test2 测试结果:" + ruleResult);
    }

    private static void test3() {
        System.out.println("==================== test3 begin =====================");

        final 班级 t = new 班级();
        t.set班级名称("三年级一班");
        t.set班级人数(11110);
        t.set班级老师("武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰" +
                "武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰" +
                "武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰" +
                "武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰" +
                "武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰" +
                "武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰" +
                "武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰武藤兰" +
                "武藤兰");


        //3. 通过以链式调用构建和执行 rule execute
        final RuleService<班级, BaseRule<班级>> base = RuleService.create();
        boolean ruleResult = base
                .and(Arrays.asList(班级人数不为空规则, 班级名称不为空规则))
                .and(Arrays.asList(班级名称最大长度255规则))
                .or(Arrays.asList(班级老师最大长度255规则, 班级人数最大值100规则))
                .execute(t);
        System.out.println("test2 测试结果:" + ruleResult);
    }
}
