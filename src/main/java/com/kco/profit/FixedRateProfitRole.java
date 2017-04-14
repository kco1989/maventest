package com.kco.profit;

/**
 * 每笔固定收益
 * Created by Administrator on 2017/4/14.
 */
public class FixedRateProfitRole implements ProfitRole {

    private double fixedRate;

    public FixedRateProfitRole(double fixedRate) {
        this.fixedRate = fixedRate * 0.01;
    }

    @Override
    public double getProfit(double money) {
        return fixedRate * money;
    }

}
