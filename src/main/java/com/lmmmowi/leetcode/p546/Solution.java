package com.lmmmowi.leetcode.p546;

/**
 * @Author: mowi
 * @Date: 2019/5/24
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().removeBoxes(new int[]{1, 2, 3, 4});
    }

    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length - l + 1; i++) {
                cal(boxes, dp, i, i + l - 1);
            }
        }

        return 0;
    }

    private void cal(int[] boxes, int[][] dp, int from, int to) {
        if (dp[from][to] > 0) {
            // 已经计算过了
            return;
        }

        int max = 0;

        // 情况一：左右两部分
        for (int i = from + 1; i <= to; i++) {
            int a = dp[from][i - 1] + dp[i][to];
            if (max < a) {
                max = a;
            }
        }

        // 情况二：两边包中间
        int color = boxes[from];
        if (boxes[to] == color) {
            int c = 0;
            for (int i = from + 1; i < to; i++) {
                if (boxes[i] == color && c == 0) {
                    c = i;
                }
                if (boxes[i] != color && c != 0) {
                    int k = 1 + 1 + (i - c);
                    int a = dp[from + 1][c - 1] + dp[i][to - 1] + k * k;
                    if (max < a) {
                        max = a;
                    }
                }
            }
        }

        System.out.println("计算 " + from + " ==> " + to);
        System.out.println(max);
    }
}
