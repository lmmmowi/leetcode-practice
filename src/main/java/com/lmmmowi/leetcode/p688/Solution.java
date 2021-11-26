package com.lmmmowi.leetcode.p688;

/**
 * @Author: lmmmowi
 * @Date: 2021/11/26
 * @Description: 688. “马”在棋盘上的概率[https://leetcode-cn.com/problems/knight-probability-in-chessboard/]
 */
public class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{2, 1}, new int[]{2, -1}, new int[]{-2, 1}, new int[]{-2, -1},
            new int[]{1, 2}, new int[]{-1, 2}, new int[]{1, -2}, new int[]{-1, -2}
    };

    public double knightProbability(int n, int k, int row, int column) {
        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 1.0;
            }
        }

        for (int p = 0; p < k; p++) {
            double[][] temp = new double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] direction : DIRECTIONS) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && y >= 0 && x < n && y < n) {
                            temp[x][y] += arr[i][j] / 8;
                        }
                    }
                }
            }

            arr = temp;
        }

        return arr[row][column];
    }
}
