package com.lmmmowi.leetcode.p122;

/**
 * @Author: 11102942
 * @Date: 2020/8/3
 * @Description: 122.买卖股票的最佳时机 II[https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/]
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int days = prices.length;
        int profit = 0;
        Integer own = null;

        for (int i = 0; i < days; i++) {
            int price = prices[i];

            // 考虑是否卖出
            if (own != null && price > own) {
                profit += price - own;
                own = null;
            }

            // 考虑是否买入
            if (i < days - 1 && price < prices[i + 1]) {
                own = price;
            }
        }

        return profit;
    }

}
