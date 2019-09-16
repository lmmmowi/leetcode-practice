package com.lmmmowi.leetcode.p79;

/**
 * @Author: 11102942
 * @Date: 2019/9/16
 * @Description: 79.单词搜索[https://leetcode-cn.com/problems/word-search/]
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        int rowCount = board.length;
        int colCount = board[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int index) {
        char target = word.charAt(index);
        char c = getBoardValue(board, row, col);
        if (target != c) {
            return false;
        }

        if (index + 1 == word.length()) {
            return true;
        }

        board[row][col] = 0;
        boolean found = search(board, word, row - 1, col, index + 1);
        found = found || search(board, word, row + 1, col, index + 1);
        found = found || search(board, word, row, col - 1, index + 1);
        found = found || search(board, word, row, col + 1, index + 1);
        board[row][col] = c;
        return found;
    }

    private char getBoardValue(char[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            return board[row][col];
        } else {
            return 0;
        }
    }
}
