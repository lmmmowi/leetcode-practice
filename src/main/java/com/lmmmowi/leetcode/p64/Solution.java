package com.lmmmowi.leetcode.p64;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/2
 * @Description: 64.最小路径和[https://leetcode-cn.com/problems/minimum-path-sum/]
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int[] lastRow = new int[w];

        for (int j = 0; j < w; j++) {
            lastRow[j] = j == 0 ? grid[0][0] : lastRow[j - 1] + grid[0][j];
        }

        for (int i = 1; i < h; i++) {
            int lastCol = Integer.MAX_VALUE;
            for (int j = 0; j < w; j++) {
                int dp = Math.min(lastCol, lastRow[j]) + grid[i][j];
                lastCol = lastRow[j] = dp;
            }
        }

        return lastRow[w - 1];
    }
}
