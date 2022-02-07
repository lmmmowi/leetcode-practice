package com.lmmmowi.leetcode.p1866;

/**
 * @Author: mowi
 * @Date: 2022/2/7
 * @Description: 1866. 恰有 K 根木棍可以看到的排列数目[https://leetcode-cn.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/]
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int rearrangeSticks(int n, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] temp = new int[k + 1];
            for (int j = 1; j <= k; j++) {
                temp[j] = (int) ((dp[j - 1] + (long) dp[j] * (i - 1) % MOD) % MOD);
            }
            dp = temp;
        }
        return dp[k];
    }
}
