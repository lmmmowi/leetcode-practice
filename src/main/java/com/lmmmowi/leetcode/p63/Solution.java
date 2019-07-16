package com.lmmmowi.leetcode.p63;

/**
 * @Author: 11102942
 * @Date: 2019/7/16
 * @Description: 63.不同路径 II[https://leetcode-cn.com/problems/unique-paths-ii/]
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[] lastRow = new int[m];

        for (int i = 0; i < n; i++) {
            int lastCol = i == 0 ? 1 : 0;

            for (int j = 0; j < m; j++) {
                lastRow[j] = obstacleGrid[i][j] == 1 ? 0 : lastRow[j] + lastCol;
                lastCol = lastRow[j];
            }
        }

        return lastRow[m - 1];
    }
}
