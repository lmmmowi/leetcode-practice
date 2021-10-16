package com.lmmmowi.leetcode.p200;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/16
 * @Description: 200. 岛屿数量[https://leetcode-cn.com/problems/number-of-islands/]
 */
public class Solution {

    int count = 0;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] islands = new int[n * m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                int index = i * m + j;
                islands[index] = index;
                count++;

                // 合并左边
                if (j > 0 && grid[i][j - 1] == '1') {
                    union(index, index - 1, islands);
                }

                // 合并上边
                if (i > 0 && grid[i - 1][j] == '1') {
                    union(index, index - m, islands);
                }
            }
        }

        return count;
    }

    private void union(int a, int b, int[] islands) {
        int pa = find(a, islands);
        int pb = find(b, islands);
        if (pa != pb) {
            islands[pa] = pb;
            count--;
        }
    }

    private int find(int a, int[] islands) {
        if (a == islands[a]) {
            return a;
        } else {
            return islands[a] = find(islands[a], islands);
        }
    }
}
