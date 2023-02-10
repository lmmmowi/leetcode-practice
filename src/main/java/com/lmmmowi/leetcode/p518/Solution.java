package com.lmmmowi.leetcode.p518;


/**
 * @Author: mowi
 * @Date: 2023/2/10
 * @Description: 518. 零钱兑换 II[https://leetcode.cn/problems/coin-change-ii/]
 */
public class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
