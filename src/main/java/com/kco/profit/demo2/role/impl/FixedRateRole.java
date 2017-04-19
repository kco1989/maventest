package com.kco.profit.demo2.role.impl;

import com.kco.profit.demo2.ProfitType;
import com.kco.profit.demo2.role.ProfitRole;
import com.kco.profit.demo2.role.factory.ProfitRoleFactory;

import java.util.regex.Matcher;

/**
 * 每笔固定收益
 * Created by Administrator on 2017/4/14.
 */
public class FixedRateRole implements ProfitRole {

    private double fixedRate;

    public FixedRateRole(double fixedRate) {
        this.fixedRate = fixedRate * 0.01;
    }

    @Override
    public double getProfit(double money) {
        return fixedRate * money;
    }

}
