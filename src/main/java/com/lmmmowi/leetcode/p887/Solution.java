package com.lmmmowi.leetcode.p887;

/**
 * @Author: 11102942
 * @Date: 2021/7/19
 * @Description: 887. 鸡蛋掉落[https://leetcode-cn.com/problems/super-egg-drop/submissions/]
 */
public class Solution {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[k][i] >= n) {
                return i;
            }
        }

        return n;
    }
}
