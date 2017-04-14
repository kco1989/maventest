package com.kco.profit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/4/14.
 */
public class TestProfitRole {

    private static final List<Double> testDate = Arrays.asList(100.0,200.0,300.0,400.0,700.0,
            1000.0,2000.0,3000.0,7000.0,
            10000.0, 20000.0, 30000.0, 70000.0);
    @Test
    public void testFixedIncome(){
        for (double data : testDate){
            double profit = ProfitRoleFactory.getProfit(data, ProfitType.FIXED_INCOME, "1.00");
            Assert.assertEquals(1.00, profit, 0.00001);
        }
    }

    @Test
    public void testFixedRate(){
        for (double data : testDate){
            double profit = ProfitRoleFactory.getProfit(data, ProfitType.FIXED_RATE, "0.1%");
            Assert.assertEquals(data * 0.1 * 0.01, profit, 0.00001);
        }
    }

    @Test
    public void testFixedRateAndFixedIncome(){
        for (double data : testDate){
            double profit = ProfitRoleFactory.getProfit(data, ProfitType.FIXED_INCOME_AND_FIXED_RATE, "0.63%+3.00");
            Assert.assertEquals(data * 0.63 * 0.01 + 3.0, profit, 0.00001);
        }
    }

    @Test
    public void testFixedRateAndUpperLimit(){
        for (double data : testDate){
            double profit = ProfitRoleFactory.getProfit(data, ProfitType.FIXED_RATE_AND_UPPER_LIMIT, "1.00~0.1%~3.00");
            double actual = data * 0.1 * 0.01;
            if (actual < 1.0){
                actual = 1.0;
            }
            if (actual > 3.0){
                actual = 3.0;
            }
            Assert.assertEquals(actual, profit, 0.00001);
        }
    }
}
