package com.lmmmowi.leetcode.p1559;

/**
 * @Author: lmmmowi
 * @Date: 2021/4/6
 * @Description: 1559. 二维网格图中探测环[https://leetcode-cn.com/problems/detect-cycles-in-2d-grid/]
 */
public class Solution {

    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                if (c > 0) {
                    boolean found = search(grid, c, i, j, 0, 0, -1, -1, visited);
                    if (found) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean search(char[][] grid, char c, int x, int y, int fx, int fy, int nx, int ny, boolean[][] visited) {
        // 不允许倒退
        if (x == nx && y == ny) {
            return false;
        }

        // 不允许越界
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }

        // 检测到环
        if (visited[x][y]) {
            return true;
        }

        // 字母必须相同
        if (grid[x][y] != c) {
            return false;
        }

        visited[x][y] = true;
        boolean found = search(grid, c, x, y - 1, x, y, fx, fy, visited);
        found = found || search(grid, c, x, y + 1, x, y, fx, fy, visited);
        found = found || search(grid, c, x - 1, y, x, y, fx, fy, visited);
        found = found || search(grid, c, x + 1, y, x, y, fx, fy, visited);
        visited[x][y] = false;
        grid[x][y] = 0;
        return found;
    }
}
