package com.lmmmowi.leetcode.p131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/18
 * @Description: 131. 分割回文串[https://leetcode-cn.com/problems/palindrome-partitioning/]
 */
public class Solution {

    public List<List<String>> partition(String s) {
        String[][] palindrome = new String[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                boolean isPalindrome = i == j || s.charAt(i) == s.charAt(j) && (i + 1 >= j - 1 || palindrome[i + 1][j - 1] != null);
                if (isPalindrome) {
                    palindrome[i][j] = s.substring(i, j + 1);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        partition(palindrome, 0, s.length() - 1, new ArrayDeque<>(), result);
        return result;
    }

    private void partition(String[][] palindrome, int head, int tail, Deque<String> stack, List<List<String>> result) {
        for (int i = head; i < tail; i++) {
            if (palindrome[head][i] != null) {
                stack.offerLast(palindrome[head][i]);
                partition(palindrome, i + 1, tail, stack, result);
                stack.pollLast();
            }
        }

        if (palindrome[head][tail] != null) {
            List<String> list = new ArrayList<>(stack);
            list.add(palindrome[head][tail]);
            result.add(list);
        }
    }
}
