package com.lmmmowi.leetcode.p36;

import java.util.BitSet;

/**
 * @Author: mowi
 * @Date: 2019-06-05
 * @Description: 36.有效的数独[https://leetcode-cn.com/problems/valid-sudoku/]
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        BitSet bitSet = new BitSet();

        // 检测行
        for (int row = 0; row < 9; row++) {
            if (!isValid(bitSet,
                    board[row][0], board[row][1], board[row][2],
                    board[row][3], board[row][4], board[row][5],
                    board[row][6], board[row][7], board[row][8])) {
                return false;
            }
        }

        // 检测列
        for (int col = 0; col < 9; col++) {
            if (!isValid(bitSet,
                    board[0][col], board[1][col], board[2][col],
                    board[3][col], board[4][col], board[5][col],
                    board[6][col], board[7][col], board[8][col])) {
                return false;
            }
        }

        // 检测3x3方块
        for (int square = 0; square < 9; square++) {
            int rb = square / 3 * 3;
            int cb = (square % 3) * 3;

            if (!isValid(bitSet,
                    board[rb][cb], board[rb][cb + 1], board[rb][cb + 2],
                    board[rb + 1][cb], board[rb + 1][cb + 1], board[rb + 1][cb + 2],
                    board[rb + 2][cb], board[rb + 2][cb + 1], board[rb + 2][cb + 2])) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(BitSet bitSet, char... chars) {
        bitSet.clear();
        for (char c : chars) {
            if (c != '.') {
                int i = c - '0';
                if (bitSet.get(i)) {
                    return false;
                } else {
                    bitSet.set(i);
                }
            }
        }
        return true;
    }
}
