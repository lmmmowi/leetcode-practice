package com.lmmmowi.leetcode.p1223;

import java.util.Arrays;

/**
 * @Author: mowi
 * @Date: 2023/2/10
 * @Description: 1223. 掷骰子模拟[https://leetcode.cn/problems/dice-roll-simulation/]
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int k = 0;
        for (int i : rollMax) {
            k = Math.max(i, k);
        }
        int[][] dp = new int[7][k + 1];
        int[][] dpx = new int[7][k + 1];
        int[] cnt = new int[7];
        int[] cntx = new int[7];
        cntx[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int num = 1; num <= 6; num++) {
                int end = Math.min(i, rollMax[num - 1]);
                for (int m = 1; m <= end; m++) {
                    dp[num][m] = m == 1 ? sum(cntx, num) : dpx[num][m - 1];
                    cnt[num] = (cnt[num] + dp[num][m]) % MOD;
                }
            }

            swap(dp, dpx);
            swap(cnt, cntx);
        }

        return sum(cntx, 0);
    }

    private int sum(int[] arr, int excludeNum) {
        int sum = 0;
        for (int num = 0; num <= 6; num++) {
            if (num != excludeNum) {
                sum = (sum + arr[num]) % MOD;
            }
        }
        return sum;
    }

    private void swap(int[][] dp, int[][] dpx) {
        for (int i = 0; i < dp.length; i++) {
            swap(dp[i], dpx[i]);
        }
    }

    private void swap(int[] cnt, int[] cntx) {
        System.arraycopy(cnt, 0, cntx, 0, cnt.length);
        Arrays.fill(cnt, 0);
    }
}
