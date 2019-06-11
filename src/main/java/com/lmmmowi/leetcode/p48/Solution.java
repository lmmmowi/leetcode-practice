package com.lmmmowi.leetcode.p48;

/**
 * @Author: mowi
 * @Date: 2019-06-11
 * @Description: 48.旋转图像[https://leetcode-cn.com/problems/rotate-image/]
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < (n - i - 1); j++) {
                int r = i, c = j;
                int val = matrix[r][c];
                int m = 0;
                while (m++ < 4) {
                    int nr = c;
                    int nc = n - r - 1;
                    int tmp = matrix[nr][nc];
                    matrix[nr][nc] = val;

                    val = tmp;
                    r = nr;
                    c = nc;
                }
            }
        }
    }
}
