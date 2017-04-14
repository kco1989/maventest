package com.kco.profit;

import java.util.regex.Matcher;

/**
 * 分润规则生成工厂
 * Created by Administrator on 2017/4/14.
 */
public final class ProfitRoleFactory {

    public static ProfitRole parseProfitRole(ProfitType type, String expression){
        Matcher matcher = type.getPattern().matcher(expression);
        if (!matcher.matches()){
            throw new RuntimeException("分润表示时不符合" + type + "的规则.");
        }
        switch (type){
            case FIXED_INCOME:
                return new FixedIncomeProfitRole(Double.parseDouble(matcher.group(1)));
            case FIXED_RATE:
                return new FixedRateProfitRole(Double.parseDouble(matcher.group(1)));
            case FIXED_RATE_AND_UPPER_LIMIT:
                return new FixedRateAndUpperLimitProfitRole(Double.parseDouble(matcher.group(1)),
                        Double.parseDouble(matcher.group(2)), Double.parseDouble(matcher.group(3)));
            case FIXED_INCOME_AND_FIXED_RATE:
                return new FixedIncomeAndFixedRateProfitRole(Double.parseDouble(matcher.group(1)),
                        Double.parseDouble(matcher.group(2)));
            default: //never come here
                return null;
        }
    }

    public static double getProfit(double money, ProfitType type, String expression){
        ProfitRole profitRole = parseProfitRole(type, expression);
        if (profitRole != null){
            return profitRole.getProfit(money);
        }
        return 0;
    }
}
