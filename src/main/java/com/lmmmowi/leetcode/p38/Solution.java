package com.lmmmowi.leetcode.p38;

/**
 * @Author: mowi
 * @Date: 2019-06-05
 * @Description: 38.报数[https://leetcode-cn.com/problems/count-and-say/]
 */
public class Solution {

    public String countAndSay(int n) {
        return handle(new StringBuilder("1"), new StringBuilder(), n, 1);
    }

    private String handle(StringBuilder result, StringBuilder working, int n, int k) {
        if (n == k) {
            return result.toString();
        }

        int len = result.length();
        int offset = 0;
        int index = 0;
        while (offset < len) {
            char c = result.charAt(offset);
            int m = 1;
            while (offset + 1 < len && result.charAt(offset + 1) == c) {
                m++;
                offset++;
            }
            putChar(working, index++, (char) (m + '0'));
            putChar(working, index++, c);

            offset++;
        }

        return handle(working, result, n, k + 1);
    }

    private void putChar(StringBuilder sb, int index, char c) {
        if (sb.length() > index) {
            sb.setCharAt(index, c);
        } else {
            sb.append(c);
        }
    }
}
