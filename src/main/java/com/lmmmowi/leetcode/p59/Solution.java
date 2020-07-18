package com.lmmmowi.leetcode.p59;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/10
 * @Description: 59.螺旋矩阵 II[https://leetcode-cn.com/problems/spiral-matrix-ii/]
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generate(matrix, 0, 0, n - 1, n - 1, 0, 0);
        return matrix;
    }

    private void generate(int[][] matrix, int l, int t, int r, int b, int currentX, int index) {
        if (l > r || t > b) {
            return;
        }

        if (currentX == l) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = ++index;
            }

            for (int i = t + 1; i <= b; i++) {
                matrix[i][r] = ++index;
            }

            generate(matrix, l, t + 1, r - 1, b, r - 1, index);
        } else {
            for (int i = r; i >= l; i--) {
                matrix[b][i] = ++index;
            }

            for (int i = b - 1; i >= t; i--) {
                matrix[i][l] = ++index;
            }

            generate(matrix, l + 1, t, r, b - 1, l + 1, index);
        }
    }
}
