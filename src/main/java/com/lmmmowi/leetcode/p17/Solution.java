package com.lmmmowi.leetcode.p17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2019-05-27
 * @Description: 17.电话号码的字母组合[https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/]
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        char[][] charCache = new char[][]{
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'g', 'h', 'i'},
                new char[]{'j', 'k', 'l'},
                new char[]{'m', 'n', 'o'},
                new char[]{'p', 'q', 'r', 's'},
                new char[]{'t', 'u', 'v'},
                new char[]{'w', 'x', 'y', 'z'}
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            sb.append(0);
        }

        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {
            this.find(result, charCache, digits, sb, 0);
        }
        return result;
    }

    private void find(List<String> result, char[][] charCache, String digits, StringBuilder sb, int n) {
        if (n >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char[] chars = charCache[digits.charAt(n) - '2'];
        for (char c : chars) {
            sb.setCharAt(n, c);
            this.find(result, charCache, digits, sb, n + 1);
        }
    }
}
