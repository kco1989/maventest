package com.kco.profit;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class GradientRateProfitRole implements ProfitRole {

    // 分润利率
    private List<Double> rates;
    // 分润界限
    private List<Double> limits;
    public GradientRateProfitRole(List<Double> rates, List<Double> limits) {
        if (CollectionUtils.isEmpty(rates) || CollectionUtils.isEmpty(limits) || rates.size() != limits.size() + 1){
            throw new RuntimeException("参数有误,参数不能为空,或rates的个数要比limits多一个");
        }
        this.rates = rates;
        this.limits = limits;
    }

    @Override
    public double getProfit(double money) {
        return money * 0.01 * rates.get(find(money)) ;
    }

    // 查看money在那个区间
    private int find(double money) {
        int result = 0;
        for(Double limit : limits){
            if (money < limits.get(result)){
                return result;
            }
            result ++;
        }
        return result;
    }
}
