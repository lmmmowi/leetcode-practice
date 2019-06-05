package com.lmmmowi.leetcode.p37;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: mowi
 * @Date: 2019-06-05
 * @Description: 37.解数独[https://leetcode-cn.com/problems/sudoku-solver/]
 */
public class Solution {

    public void solveSudoku(char[][] board) {
        short[][] states = initStates(board);
        AtomicBoolean done = new AtomicBoolean(false);
        solve(board, states, done, 0, 0);
    }

    private short[][] initStates(char[][] board) {
        // 记录状态，states[0]记录行，states[1]记录列，states[2]记录方块
        short[][] states = new short[3][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int index = board[row][col] - '1';
                    states[0][row] |= 1 << index;
                    states[1][col] |= 1 << index;
                    states[2][row / 3 * 3 + col / 3] |= 1 << index;
                }
            }
        }

        return states;
    }

    private void solve(char[][] board, short[][] states, AtomicBoolean done, int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            done.set(true);
            return;
        }

        if (board[row][col] != '.') {
            solve(board, states, done, row, col + 1);
        } else {
            int square = row / 3 * 3 + col / 3;
            for (int i = 0; i < 9; i++) {
                if (checkBit(states[0][row], i) || checkBit(states[1][col], i) || checkBit(states[2][square], i)) {
                    continue;
                }

                // 填充数字
                board[row][col] = (char) ('1' + i);
                states[0][row] |= 1 << i;
                states[1][col] |= 1 << i;
                states[2][square] |= 1 << i;

                solve(board, states, done, row, col + 1);
                if (done.get()) {
                    break;
                }

                // 取消填充数字
                board[row][col] = '.';
                states[0][row] &= ~(1 << i);
                states[1][col] &= ~(1 << i);
                states[2][square] &= ~(1 << i);
            }
        }
    }

    private boolean checkBit(short s, int index) {
        return (s & 1 << index) != 0;
    }
}
