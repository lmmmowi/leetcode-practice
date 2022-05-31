package com.lmmmowi.leetcode.p1444;

/**
 * @Author: mowi
 * @Date: 2022/5/31
 * @Description: 1444. 切披萨的方案数[https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/]
 */
public class Solution {
    private static final int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        int row = pizza.length;
        int col = pizza[0].length();
        int[][][] dp = new int[row][col][k];

        for (int m = 0; m < k; m++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    dp[i][j][m] = calc(pizza, i, j, m, dp);
                }
            }
        }

        return dp[0][0][k - 1];
    }

    private int calc(String[] pizza, int x, int y, int m, int[][][] dp) {
        int lastX = pizza.length - 1;
        int lastY = pizza[0].length() - 1;

        if (m == 0) {
            // 不需要切
            return hasApple(pizza, x, y, lastX, lastY) ? 1 : 0;
        }

        int result = 0;

        // 横切
        for (int i = x; i < lastX; i++) {
            int remaining = dp[i + 1][y][m - 1];
            if (remaining > 0 && hasApple(pizza, x, y, i, lastY)) {
                result += remaining;
                result %= MOD;
            }
        }

        // 竖切
        for (int i = y; i < lastY; i++) {
            int remaining = dp[x][i + 1][m - 1];
            if (remaining > 0 && hasApple(pizza, x, y, lastX, i)) {
                result += remaining;
                result %= MOD;
            }
        }

        return result;
    }

    private boolean hasApple(String[] pizza, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    return true;
                }
            }
        }
        return false;
    }
}