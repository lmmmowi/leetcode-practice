package com.lmmmowi.leetcode.p212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/16
 * @Description: 212. 单词搜索 II[https://leetcode-cn.com/problems/word-search-ii/]
 */
public class Solution {

    private static final char TRAVELED = 0;
    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{1, 0}, new int[]{-1, 0},
            new int[]{0, 1}, new int[]{0, -1},
    };

    public List<String> findWords(char[][] board, String[] words) {
        TrieTreeNode trie = this.buildTrieTree(words);
        Set<String> result = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                findWords(board, i, j, trie, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void findWords(char[][] board, int row, int col, TrieTreeNode trie, Set<String> result) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        char c = board[row][col];
        if (c == TRAVELED) {
            return;
        }

        TrieTreeNode child = trie.find(c);
        if (child == null) {
            return;
        }

        if (child.word != null) {
            result.add(child.word);
        }

        board[row][col] = TRAVELED;
        for (int[] direction : DIRECTIONS) {
            findWords(board, row + direction[0], col + direction[1], child, result);
        }
        board[row][col] = c;
    }

    private TrieTreeNode buildTrieTree(String[] words) {
        TrieTreeNode root = new TrieTreeNode((char) 0);
        for (String word : words) {
            TrieTreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieTreeNode child = node.find(c);
                node = child != null ? child : node.insert(c);
            }
            node.word = word;
        }
        return root;
    }

    private class TrieTreeNode {
        private char value;
        private String word;
        private TrieTreeNode[] children = new TrieTreeNode[26];

        public TrieTreeNode(char value) {
            this.value = value;
        }

        public TrieTreeNode find(char value) {
            int index = value - 'a';
            return children[index];
        }

        public TrieTreeNode insert(char value) {
            int index = value - 'a';
            children[index] = new TrieTreeNode(value);
            return children[index];
        }
    }
}
