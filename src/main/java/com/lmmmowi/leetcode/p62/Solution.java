package com.lmmmowi.leetcode.p62;

/**
 * @Author: lmmmowi
 * @Date: 2019/6/25
 * @Description: 62.不同路径[https://leetcode-cn.com/problems/unique-paths/]
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[] lastRow = new int[m];

        for (int i = 0; i < n; i++) {
            int lastCol = i == 0 ? 1 : 0;

            for (int j = 0; j < m; j++) {
                lastRow[j] = lastRow[j] + lastCol;
                lastCol = lastRow[j];
            }
        }

        return lastRow[m - 1];
    }

}
