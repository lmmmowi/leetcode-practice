package com.lmmmowi.leetcode.p1320;

import java.util.Arrays;

/**
 * @Author: lmmmowi
 * @Date: 2022/12/4
 * @Description: 1320. 二指输入的的最小距离[https://leetcode.cn/problems/minimum-distance-to-type-a-word-using-two-fingers/]
 */
public class Solution {

    private static final int VERY_LARGE_NUMBER = 99999999;

    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dist = intDistance();
        int[][][] dp = initDp(n);

        int first = word.charAt(0) - 'A';
        for (int i = 0; i < 26; i++) {
            dp[0][first][i] = 0;
            dp[0][i][first] = 0;
        }

        for (int i = 1; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';

            for (int j = 0; j < 26; j++) {
                // cur on left and prev on left
                dp[i][cur][j] = Math.min(dp[i][cur][j], dp[i - 1][prev][j] + dist[prev][cur]);

                // cur on right and prev on right
                dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i - 1][j][prev] + dist[prev][cur]);

                if (j == prev) {
                    for (int k = 0; k < 26; k++) {
                        // cur on left and prev on right
                        dp[i][cur][j] = Math.min(dp[i][cur][j], dp[i - 1][k][prev] + dist[k][cur]);

                        // cur on right and prev on left
                        dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i - 1][prev][k] + dist[k][cur]);
                    }
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                minDist = Math.min(minDist, dp[n - 1][i][j]);
            }
        }
        return minDist;
    }

    private int[][] intDistance() {
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int ir = i / 6;
                int ic = i % 6;
                int jr = j / 6;
                int jc = j % 6;
                dist[i][j] = dist[j][i] = Math.abs(ir - jr) + Math.abs(ic - jc);
            }
        }
        return dist;
    }

    private int[][][] initDp(int n) {
        int[][][] dp = new int[n][26][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], VERY_LARGE_NUMBER);
            }
        }
        return dp;
    }
}
