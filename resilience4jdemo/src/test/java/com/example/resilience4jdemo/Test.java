package com.example.resilience4jdemo;

import lombok.Data;

public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        long oldCashBalance = 10, cost = 30, oldActivityBalance = 10;
        CostInfo costInfo = new CostInfo();
        if (oldCashBalance <= cost) {
            long remain = cost;
            if (oldCashBalance <= 0) {
                costInfo.setCastCost(0);
                costInfo.setWalletCastBalance(oldCashBalance);
            } else {
                costInfo.setCastCost(oldCashBalance);
                costInfo.setWalletCastBalance(0);
                remain = cost - oldCashBalance;
            }
            if (oldActivityBalance >= remain) {
                costInfo.setActivityCost(remain);
                costInfo.setWalletActivityBalance(oldActivityBalance - remain);
            } else {
                costInfo.setActivityCost(oldActivityBalance);
                costInfo.setWalletActivityBalance(0);
                remain -= oldActivityBalance;
                costInfo.setCastCost(remain + costInfo.getCastCost());
                costInfo.setWalletCastBalance(costInfo.getWalletCastBalance() - remain);
            }
        } else {
            costInfo.setCastCost(cost);
            costInfo.setActivityCost(0);
            costInfo.setWalletCastBalance(oldCashBalance - cost);
            costInfo.setWalletActivityBalance(oldActivityBalance);
        }
        System.out.println(costInfo);
    }
    @Data
    private class CostInfo {
        // 消费金额
        long cost;
        // castCost : 现金消耗
        long castCost;
        // activityCost ： 活动余额消耗
        long activityCost;
        // 结算后的钱包现金余额
        long walletCastBalance;
        // 结算后的钱包活动余额
        long walletActivityBalance;
        // 计费规则
        //RuleData rule;
        // 课时
        int courseTime;
        // 当前时间戳
        long curTime;
    }
}
