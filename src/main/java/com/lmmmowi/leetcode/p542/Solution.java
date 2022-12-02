package com.lmmmowi.leetcode.p542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lmmmowi
 * @Date: 2022/12/2
 * @Description: 542. 01 矩阵[https://leetcode.cn/problems/01-matrix/]
 */
public class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{0, -1}, new int[]{0, 1},
            new int[]{-1, 0}, new int[]{1, 0},
    };

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(result[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (result[nx][ny] == -1) {
                        result[nx][ny] = result[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return result;
    }
}
