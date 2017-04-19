package com.kco.profit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            case GRADIENT_RATE:
                List<Double> rates = new ArrayList<>();
                List<Double> limits = new ArrayList<>();
                Pattern numberPattern = ProfitType.getNumberPattern();
                Matcher numberMatcher = numberPattern.matcher(expression);
                for (int i = 0;numberMatcher.find();i ++){
                    if (i % 2 == 0){
                        rates.add(Double.parseDouble(numberMatcher.group()));
                    }else{
                        limits.add(Double.parseDouble(numberMatcher.group()));
                    }
                }
                return new GradientRateProfitRole(rates, limits);
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
