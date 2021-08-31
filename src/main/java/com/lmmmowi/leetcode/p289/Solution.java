package com.lmmmowi.leetcode.p289;

/**
 * @Author: lmmmowi
 * @Date: 2021/8/31
 * @Description: 289. 生命游戏[https://leetcode-cn.com/problems/game-of-life/]
 */
public class Solution {

    public void gameOfLife(int[][] board) {
        int[][] directions = new int[][]{
                new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1},
                new int[]{0, -1}, new int[]{0, 1},
                new int[]{1, -1}, new int[]{1, 0}, new int[]{1, 1},
        };

        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveCount = 0;
                for (int[] direction : directions) {
                    int ii = i + direction[0];
                    int jj = j + direction[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && board[ii][jj] % 2 == 1) {
                        liveCount++;
                    }
                }

                if ((liveCount < 2 || liveCount > 3) && board[i][j] == 1) {
                    board[i][j] = 3;
                } else if (liveCount == 3 && board[i][j] == 0) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
