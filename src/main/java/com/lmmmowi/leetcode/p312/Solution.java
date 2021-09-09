package com.lmmmowi.leetcode.p312;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/8
 * @Description: 312. 戳气球[https://leetcode-cn.com/problems/burst-balloons/]
 */
public class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = n + 2;
        int[] temp = new int[m];
        System.arraycopy(nums, 0, temp, 1, n);
        temp[0] = temp[m - 1] = 1;
        nums = temp;

        int[][] dp = new int[m][m];
        for (int len = 1; len <= n; len++) {
            for (int left = 0; left < m; left++) {
                int right = left + len + 1;
                if (right >= m) {
                    break;
                }

                int maxScore = 0;
                for (int i = left + 1; i < right; i++) {
                    int leftScore = dp[left][i];
                    int rightScore = dp[i][right];
                    int score = nums[left] * nums[i] * nums[right];
                    maxScore = Math.max(maxScore, leftScore + rightScore + score);
                }
                dp[left][right] = maxScore;
            }
        }

        return dp[0][m - 1];
    }
}
