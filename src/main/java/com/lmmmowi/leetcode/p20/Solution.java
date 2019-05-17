package com.lmmmowi.leetcode.p20;

import java.util.Stack;

/**
 * @Author: mowi
 * @Date: 2019-05-17
 * @Description: 20.有效的括号[https://leetcode-cn.com/problems/valid-parentheses/]
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if (stack.isEmpty() || stack.pop() / 10 != c / 10) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
