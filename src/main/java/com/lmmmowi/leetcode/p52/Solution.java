package com.lmmmowi.leetcode.p52;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: mowi
 * @Date: 2019-06-12
 * @Description: 52.N皇后 II[https://leetcode-cn.com/problems/n-queens-ii/]
 */
public class Solution {

    public int totalNQueens(int n) {
        AtomicInteger count = new AtomicInteger();

        // flag[0]记录列的占用，flag[1]记录右对角线的占用，flag[2]记录左对角线的占用
        int[][] flags = new int[3][n * 2];

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        this.solve(count, board, flags, n, 0);
        return count.get();
    }

    private void solve(AtomicInteger count, char[][] board, int[][] flags, int n, int row) {
        if (row == n) {
            count.incrementAndGet();
            return;
        }

        for (int col = 0; col < n; col++) {
            // r的计算加了n是为了防止出现负数
            int r = row - col + n;
            int l = row + col;
            if (flags[0][col] + flags[1][r] + flags[2][l] > 0) {
                continue;
            }

            // 标记占用
            flags[0][col] = 1;
            flags[1][r] = 1;
            flags[2][l] = 1;
            board[row][col] = 'Q';

            // 尝试下一行
            this.solve(count, board, flags, n, row + 1);

            // 取消标记占用
            board[row][col] = '.';
            flags[0][col] = 0;
            flags[1][r] = 0;
            flags[2][l] = 0;
        }
    }
}
