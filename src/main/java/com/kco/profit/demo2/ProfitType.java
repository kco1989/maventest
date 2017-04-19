package com.kco.profit.demo2;

import com.kco.profit.demo2.role.ProfitRole;
import com.kco.profit.demo2.role.factory.ProfitRoleFactory;
import com.kco.profit.demo2.role.factory.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/19.
 */
public class ProfitType {
    // 非捕捉匹配正实数
    private static final String number = "(?:(?:[1-9]+\\d*)|(?:\\d))(?:\\.\\d+)?";
    // 捕捉匹配正实数
    private static final String realNumber = "(" + number + ")";
    // 捕捉匹配百分比
    private static final String rateNumber = realNumber + "%";

    // 分润规则map
    private static final Map<String, ProfitType> profitTypeMap = new HashMap<>();

    // 注册默认的分润规则
    static {
        registerProfitRole("FIXED_INCOME", "^" + ProfitType.realNumber + "$", new FixedIncomeRoleFactory());
        registerProfitRole("FIXED_RATE", "^"+ ProfitType.rateNumber +"$", new FixedRateRoleFactory());
        registerProfitRole("FIXED_RATE_AND_FIXED_INCOME", "^"+ ProfitType.rateNumber  + "\\+" + ProfitType.realNumber + "$", new FixedRateAndFixedIncomeRoleFactory());
        registerProfitRole("FIXED_RATE_AND_UPPER_LIMIT", "^"+ ProfitType.realNumber + "~" + ProfitType.rateNumber + "~" + ProfitType.realNumber  + "$", new FixedRateAndUpperLimitRoleFactory());
        registerProfitRole("GRADIENT_RATE", "^"+ ProfitType.rateNumber+"(<"+ ProfitType.realNumber+"<"+ ProfitType.rateNumber+")+$", new GradientRateRoleFactory());
    }
    
    private String name;
    private String expression;
    private ProfitRoleFactory factory;

    public ProfitType(String name, String expression, ProfitRoleFactory factory) {
        this.name = name;
        this.expression = expression;
        this.factory = factory;
    }

    public static Pattern getNumberPattern() {
        return Pattern.compile(number);
    }

    public String getName() {
        return name;
    }

    public Pattern getPattern(){
        return Pattern.compile(this.expression);
    }

    /**
     * 注册分润规则类型
     */
    public static void registerProfitRole(String name, String profitRoleExpression,ProfitRoleFactory factory){
        if (profitTypeMap.containsKey(name)){
            throw new RuntimeException("该"+name+"分润规则已经存在");
        }
        profitTypeMap.put(name, new ProfitType(name, profitRoleExpression, factory));
    }

    /**
     * 根据分润规则名字获取分润规则类型
     */
    public static ProfitType getProfitType(String name){
        return profitTypeMap.get(name);
    }
}
