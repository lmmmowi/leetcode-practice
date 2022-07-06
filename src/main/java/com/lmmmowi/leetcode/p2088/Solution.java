package com.lmmmowi.leetcode.p2088;

/**
 * @Author: mowi
 * @Date: 2022/7/6
 * @Description: 2088. 统计农场中肥沃金字塔的数目[https://leetcode.cn/problems/count-fertile-pyramids-in-a-land/]
 */
public class Solution {

    public int countPyramids(int[][] grid) {
        return countPyramids(grid, true) + countPyramids(grid, false);
    }

    private int countPyramids(int[][] grid, boolean positive) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] prev = new int[cols];
        int[] cur = new int[cols];

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int r = positive ? rows - 1 - i : i;
            for (int c = 0; c < grid[r].length; c++) {
                cur[c] = grid[r][c] == 0 ? 0 : 1 + min(prev, c);
                result += Math.max(cur[c] - 1, 0);
            }

            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return result;
    }

    private int min(int[] row, int col) {
        int left = col - 1 >= 0 ? row[col - 1] : 0;
        int right = col + 1 < row.length ? row[col + 1] : 0;
        return Math.min(row[col], Math.min(left, right));
    }
}
