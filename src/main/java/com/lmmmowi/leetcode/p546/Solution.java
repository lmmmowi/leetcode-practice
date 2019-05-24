package com.lmmmowi.leetcode.p546;

/**
 * @Author: mowi
 * @Date: 2019/5/24
 * @Description: 546.移除盒子[https://leetcode-cn.com/problems/remove-boxes/]
 */
public class Solution {

    public int removeBoxes(int[] boxes) {
        int length = boxes.length;

        // dp[i][j][k]表示假设[i-k, i]颜色都相同的情况下，[i-k, j]范围所能取到的最大值
        // 即boxes[i]左边有k个与其相同颜色的盒子
        int[][][] dp = new int[length][length][length];

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < i; k++) {
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }

        return calculate(boxes, dp, 0, length - 1, 0);
    }

    private int calculate(int[] boxes, int[][][] dp, int i, int j, int k) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }

        // 情况一
        // [i-k, i]作为整体取出，最大值为(k+1)*(k+1)
        // [i+1, j]部分作为整体取出，最大值为dp[i+1][j][0]
        int res = (k + 1) * (k + 1) + calculate(boxes, dp, i + 1, j, 0);

        // 情况二
        // [i+1, m-i]作为整体取出，最大值为dp[i+1][m-1][0]
        // [i-k, i]和[m, j]合并后作为整体取出，最大值等价于dp[m][j][k+1]
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                int a = calculate(boxes, dp, i + 1, m - 1, 0);
                int b = calculate(boxes, dp, m, j, k + 1);
                res = Math.max(res, a + b);
            }
        }

        return dp[i][j][k] = res;
    }
}
