package com.lmmmowi.lcof.p63;

/**
 * @Author: 11102942
 * @Date: 2021/3/18
 * @Description: 剑指 Offer 63. 股票的最大利润[https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/]
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length > 0) {
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
        }
        return maxProfit;
    }
}
