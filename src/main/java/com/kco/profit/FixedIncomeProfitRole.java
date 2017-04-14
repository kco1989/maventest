package com.kco.profit;

/**
 * 每笔固定收益
 * Created by Administrator on 2017/4/14.
 */
public class FixedIncomeProfitRole implements ProfitRole{
    private double fixedIncome;

    public FixedIncomeProfitRole(double fixedIncome) {
        this.fixedIncome = fixedIncome;
    }

    @Override
    public double getProfit(double money) {
        if (money - fixedIncome < 0){
            throw new RuntimeException(String.format("本金(%s)比利润(%s)元还低", money, fixedIncome));
        }
        return fixedIncome;
    }
}
