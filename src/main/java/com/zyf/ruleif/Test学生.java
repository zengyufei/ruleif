package com.zyf.ruleif;

import com.zyf.ruleif.base.BaseRule;
import com.zyf.ruleif.base.RuleService;
import com.zyf.ruleif.entity.学生;
import com.zyf.ruleif.rules.学生校验规则.*;

import java.util.Arrays;

public class Test学生 {

    static 体重不为空校验 体重不为空规则 = new 体重不为空校验();
    static 姓名不为空校验 姓名不为空规则 = new 姓名不为空校验();
    static 年龄不为空校验 年龄不为空规则 = new 年龄不为空校验();
    static 性别不为空校验 性别不为空规则 = new 性别不为空校验();
    static 身高不为空校验 身高不为空规则 = new 身高不为空校验();

    static 体重不为0校验 体重不为0规则 = new 体重不为0校验();
    static 身高不为0校验 身高不为0规则 = new 身高不为0校验();
    static 年龄不为于0校验 年龄不为于0规则 = new 年龄不为于0校验();

    static 姓名最大长度255校验 姓名最大长度255规则 = new 姓名最大长度255校验();
    static 姓名长度大于1校验 姓名长度大于1规则 = new 姓名长度大于1校验();
    static 性别最大长度1校验 性别最大长度1规则 = new 性别最大长度1校验();

    static 性别范围校验 性别范围规则 = new 性别范围校验();

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        /*
         * 执行结果：
         * ==================== test1 begin =====================
         * test1 测试结果:true
         * ==================== test2 begin =====================
         * com.zyf.ruleif.rules.学生校验规则.性别最大长度1校验 校验不通过!
         * test2 测试结果:false
         * ==================== test3 begin =====================
         * com.zyf.ruleif.rules.学生校验规则.年龄不为于0校验 校验不通过!
         * test2 测试结果:false
         * */
    }

    private static void test1() {
        System.out.println("==================== test1 begin =====================");

        学生 t = new 学生();
        t.set姓名("张三");
        t.set性别("男");
        t.set身高(168.1D);
        t.set体重(57.5D);
        t.set年龄(17);

        //3. 通过以链式调用构建和执行 rule execute
        final RuleService<学生, BaseRule<学生>> base = RuleService.create();
        boolean ruleResult = base
                .and(Arrays.asList(体重不为空规则, 姓名不为空规则, 年龄不为空规则, 性别不为空规则, 身高不为空规则))
                .and(Arrays.asList(体重不为0规则, 身高不为0规则, 年龄不为于0规则))
                .and(Arrays.asList(姓名最大长度255规则, 姓名长度大于1规则, 性别最大长度1规则))
                .and(Arrays.asList(性别范围规则))
                .execute(t);
        System.out.println("test1 测试结果:" + ruleResult);
    }

    private static void test2() {
        System.out.println("==================== test2 begin =====================");

        学生 t = new 学生();
        t.set姓名("张三");
        t.set性别("男男男男男男男男男男男男男男男男男男男男男男");
        t.set身高(168.1D);
        t.set体重(57.5D);
        t.set年龄(17);

        //3. 通过以链式调用构建和执行 rule execute
        final RuleService<学生, BaseRule<学生>> base = RuleService.create();
        boolean ruleResult = base
                .and(Arrays.asList(体重不为空规则, 姓名不为空规则, 年龄不为空规则, 性别不为空规则, 身高不为空规则))
                .and(Arrays.asList(体重不为0规则, 身高不为0规则, 年龄不为于0规则))
                .and(Arrays.asList(姓名最大长度255规则, 姓名长度大于1规则, 性别最大长度1规则))
                .and(Arrays.asList(性别范围规则))
                .execute(t);
        System.out.println("test2 测试结果:" + ruleResult);
    }

    private static void test3() {
        System.out.println("==================== test3 begin =====================");

        学生 t = new 学生();
        t.set姓名("张三");
        t.set性别("男");
        t.set身高(168.1D);
        t.set体重(57.5D);
        t.set年龄(0);

        //3. 通过以链式调用构建和执行 rule execute
        final RuleService<学生, BaseRule<学生>> base = RuleService.create();
        boolean ruleResult = base
                .and(Arrays.asList(体重不为空规则, 姓名不为空规则, 年龄不为空规则, 性别不为空规则, 身高不为空规则))
                .and(Arrays.asList(体重不为0规则, 身高不为0规则, 年龄不为于0规则))
                .and(Arrays.asList(姓名最大长度255规则, 姓名长度大于1规则, 性别最大长度1规则))
                .and(Arrays.asList(性别范围规则))
                .execute(t);
        System.out.println("test2 测试结果:" + ruleResult);
    }
}
