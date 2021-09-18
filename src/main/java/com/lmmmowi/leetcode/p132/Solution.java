package com.lmmmowi.leetcode.p132;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/18
 * @Description: 132. 分割回文串 II[https://leetcode-cn.com/problems/palindrome-partitioning-ii/]
 */
public class Solution {

    public int minCut(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                palindrome[i][j] = i == j || s.charAt(i) == s.charAt(j) && (i + 1 >= j - 1 || palindrome[i + 1][j - 1]);
            }
        }

        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (!palindrome[0][i]) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= i; k++) {
                    if (palindrome[k][i]) {
                        min = Math.min(min, 1 + dp[k - 1]);
                    }
                }
                dp[i] = min;
            }
        }

        return dp[s.length() - 1];
    }
}
