package com.lmmmowi.leetcode.p741;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/9
 * @Description: 741.摘樱桃[https://leetcode-cn.com/problems/cherry-pickup/]
 */
public class Solution {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];

        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < n; y1++) {
                int step = x1 + y1;
                if (step == 0) {
                    dp[0][0][0] = grid[x1][y1];
                    continue;
                }

                for (int x2 = 0; x2 < n; x2++) {
                    int y2 = step - x2;
                    if (y2 < 0 || y2 >= n) {
                        continue;
                    }

                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[x1][y1][x2] = Integer.MIN_VALUE;
                    } else {
                        int count = x1 != x2 ? grid[x1][y1] + grid[x2][y2] : grid[x1][y1];
                        dp[x1][y1][x2] = count + getMaxCountForLastStep(dp, x1, y1, x2, y2);
                    }
                }
            }
        }

        return Math.max(dp[n - 1][n - 1][n - 1], 0);
    }

    private int getMaxCountForLastStep(int[][][] dp, int x1, int y1, int x2, int y2) {
        int max = Integer.MIN_VALUE;
        if (x1 > 0) {
            if (x2 > 0) {
                max = Math.max(max, dp[x1 - 1][y1][x2 - 1]);
            }
            if (y2 > 0) {
                max = Math.max(max, dp[x1 - 1][y1][x2]);
            }
        }
        if (y1 > 0) {
            if (x2 > 0) {
                max = Math.max(max, dp[x1][y1 - 1][x2 - 1]);
            }
            if (y2 > 0) {
                max = Math.max(max, dp[x1][y1 - 1][x2]);
            }
        }
        return max;
    }
}
