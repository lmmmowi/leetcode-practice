package com.lmmmowi.leetcode.p130;

/**
 * @Author: mowi
 * @Date: 2022/2/15
 * @Description: 130. 被围绕的区域[https://leetcode-cn.com/problems/surrounded-regions/]
 */
public class Solution {

    private int n;
    private int m;

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        for (int i = 0; i < m; i++) {
            fill(board, 0, i);
            fill(board, n - 1, i);
        }
        for (int i = 1; i < n - 1; i++) {
            fill(board, i, 0);
            fill(board, i, m - 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void fill(char[][] board, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return;
        }

        char c = board[row][col];
        if (c == 'X' || c == 'Y') {
            return;
        }

        board[row][col] = 'Y';
        fill(board, row, col - 1);
        fill(board, row, col + 1);
        fill(board, row - 1, col);
        fill(board, row + 1, col);
    }
}
