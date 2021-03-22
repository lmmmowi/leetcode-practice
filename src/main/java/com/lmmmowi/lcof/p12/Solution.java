package com.lmmmowi.lcof.p12;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/22
 * @Description: 剑指 Offer 12. 矩阵中的路径[https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/]
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstLetter) {
                    boolean found = exist(board, word, i, j, 1);
                    if (found) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int row, int col, int index) {
        if (index >= word.length()) {
            return true;
        }

        char targetLetter = word.charAt(index);
        boolean found = false;

        // prepare
        char origin = board[row][col];
        board[row][col] = 0;

        // 上
        if (row > 0 && board[row - 1][col] == targetLetter) {
            found = exist(board, word, row - 1, col, index + 1);
        }

        // 下
        if (!found && row + 1 < board.length && board[row + 1][col] == targetLetter) {
            found = exist(board, word, row + 1, col, index + 1);
        }

        // 左
        if (!found && col > 0 && board[row][col - 1] == targetLetter) {
            found = exist(board, word, row, col - 1, index + 1);
        }

        // 右
        if (!found && col + 1 < board[0].length && board[row][col + 1] == targetLetter) {
            found = exist(board, word, row, col + 1, index + 1);
        }

        // clean
        board[row][col] = origin;

        return found;
    }
}
