package com.lmmmowi.leetcode.p1559;

/**
 * @Author: lmmmowi
 * @Date: 2021/4/6
 * @Description: 1559. 二维网格图中探测环[https://leetcode-cn.com/problems/detect-cycles-in-2d-grid/]
 */
public class Solution {

    private static final int[][] STEPS = new int[][]{
            new int[]{0, -1}, new int[]{0, 1},
            new int[]{-1, 0}, new int[]{1, 0}
    };

    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                if (c > 0) {
                    boolean found = search(grid, c, i, j, 0, 0, visited);
                    if (found) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean search(char[][] grid, char c, int x, int y, int fx, int fy, boolean[][] visited) {
        visited[x][y] = true;

        for (int[] step : STEPS) {
            int nx = x + step[0], ny = y + step[1];

            // 不允许倒退
            if (nx == fx && ny == fy) {
                continue;
            }

            // 不允许越界
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }

            // 字母必须相同
            if (grid[nx][ny] != c) {
                continue;
            }

            // 检测到环
            if (visited[nx][ny]) {
                return true;
            }

            if (search(grid, c, nx, ny, x, y, visited)) {
                return true;
            }
        }

        visited[x][y] = false;
        grid[x][y] = 0;
        return false;
    }
}
