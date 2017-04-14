package com.kco.profit;

import java.util.regex.Pattern;

/**
 * 分润规则类型
 * Created by Administrator on 2017/4/14.
 */
public enum ProfitType {
    /**
     * 每笔固定收益1元，则填写代理商收益1.00;
     */
    FIXED_INCOME("^" + ProfitType.realNumber + "$"),
    /**
     * 每笔收益率为0.1%则填写代理商收益0.1%;
     */
    FIXED_RATE("^"+ ProfitType.rateNumber +"$"),
    /**
     * 每笔收益率为0.1%加上固定收益1元，则填写代理商收益0.1%+1.00;
     */
    FIXED_INCOME_AND_FIXED_RATE("^"+ProfitType.rateNumber  + "\\+" + ProfitType.realNumber + "$"),
    /**
     * 每笔收益率为0.1%，封顶3元，保底1元则填写代理商收益1.00~0.1%~3.00;
     */
    FIXED_RATE_AND_UPPER_LIMIT("^"+ ProfitType.realNumber + "~" + ProfitType.rateNumber + "~" + ProfitType.realNumber  + "$");

    // 非捕捉匹配正实数
    private static final String number = "(?:(?:[1-9]+\\d*)|(?:\\d))(?:\\.\\d+)?";
    // 捕捉匹配正实数
    private static final String realNumber = "(" + number + ")";
    // 捕捉匹配百分比
    private static final String rateNumber = realNumber + "%";

    private String pattern;
    ProfitType(String pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return Pattern.compile(this.pattern);
    }

}
