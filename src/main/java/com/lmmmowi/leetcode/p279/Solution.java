package com.lmmmowi.leetcode.p279;

/**
 * @Author: lmmmowi
 * @Date: 2023/4/10
 * @Description: 279. 完全平方数[https://leetcode.cn/problems/perfect-squares/]
 */
public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j * j <= i; j++) {
                num = Math.min(num, dp[i - j * j] + 1);
            }
            dp[i] = num;
        }

        return dp[n];
    }
}
