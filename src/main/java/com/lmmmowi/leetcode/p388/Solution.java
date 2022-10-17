package com.lmmmowi.leetcode.p388;

import java.util.Stack;

/**
 * 388. 文件的最长绝对路径[https://leetcode.cn/problems/longest-absolute-file-path/]
 *
 * @author lmmmowi
 * @version 1.0
 * @since 2022/10/17 18:03
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt");
    }

    public int lengthLongestPath(String input) {
        Stack<Node> stack = new Stack<>();
        int lengthStr = 0;
        int level = 0;
        boolean isFile = false;

        int result = 0;
        int lengthInput = input.length();
        for (int i = 0; i <= lengthInput; i++) {
            char c = i < lengthInput ? input.charAt(i) : '\n';
            switch (c) {
                case '\n':
                    Node topNode = null;
                    while (!stack.isEmpty()) {
                        topNode = stack.peek();
                        if (topNode.level >= level) {
                            stack.pop();
                            topNode = null;
                        } else {
                            break;
                        }
                    }

                    int lengthPrev = topNode == null ? 0 : topNode.length + 1;
                    Node node = new Node(level, lengthPrev + lengthStr);
                    stack.add(node);
                    if (isFile) {
                        result = Math.max(result, node.length);
                    }

                    // 重置
                    lengthStr = 0;
                    level = 0;
                    isFile = false;
                    break;
                case '\t':
                    level++;
                    break;
                default:
                    lengthStr++;
                    isFile |= c == '.';
            }
        }

        return result;
    }

    private static class Node {
        private int level;
        private int length;

        public Node(int level, int length) {
            this.level = level;
            this.length = length;
        }
    }
}
