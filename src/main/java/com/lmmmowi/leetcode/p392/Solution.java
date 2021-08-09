package com.lmmmowi.leetcode.p392;

/**
 * @Author: lmmmowi
 * @Date: 2021/8/9
 * @Description: 392. 判断子序列[https://leetcode-cn.com/problems/is-subsequence/]
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = i == 0 || dp[i][j - 1] || (dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1));
            }
        }

        return dp[m][n];
    }
}
