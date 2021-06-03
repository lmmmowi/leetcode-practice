package com.lmmmowi.leetcode.p301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lmmmowi
 * @Date: 2021/6/3
 * @Description: 301. 删除无效的括号[https://leetcode-cn.com/problems/remove-invalid-parentheses/]
 */
public class Solution {

    private Set<String> resultSet = new HashSet<>();
    private int resultLength = 0;

    public List<String> removeInvalidParentheses(String s) {
        dfs(s.toCharArray(), 0, 0, 0, s.length());
        return new ArrayList<>(resultSet);
    }

    private void dfs(char[] chars, int index, int l, int r, int retainedLength) {
        if (index == chars.length) {
            if (l == r) {
                saveResult(chars);
            }
            return;
        }

        if (l < r) {
            return;
        }

        int unreachedLength = chars.length - index;
        if (l > r + unreachedLength) {
            return;
        }

        char c = chars[index];
        switch (c) {
            case '(':
            case ')':
                // 保留
                if (c == '(') {
                    dfs(chars, index + 1, l + 1, r, retainedLength);
                } else if (l > r) {
                    dfs(chars, index + 1, l, r + 1, retainedLength);
                }

                // 删除
                if (retainedLength > resultLength) {
                    chars[index] = 0;
                    dfs(chars, index + 1, l, r, retainedLength - 1);
                    chars[index] = c;
                }
                break;
            default:
                // 保留
                dfs(chars, index + 1, l, r, retainedLength);
        }
    }

    private void saveResult(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c > 0) {
                sb.append(c);
            }
        }
        String s = sb.toString();

        if (s.length() > resultLength) {
            resultSet.clear();
            resultLength = s.length();
        }
        resultSet.add(s);
    }
}
