package com.lmmmowi.leetcode.p524;

import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2021/1/6
 * @Description: 524.通过删除字母匹配到字典里最长单词[https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/]
 */
public class Solution {

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String word : d) {
            if (check(s, word) && compare(result, word)) {
                result = word;
            }
        }
        return result;
    }

    private boolean check(String s, String word) {
        int n = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean found = false;
            while (n < s.length()) {
                char sc = s.charAt(n++);
                if (sc == c) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    private boolean compare(String oldStr, String newStr) {
        return newStr.length() > oldStr.length()
                || (newStr.length() == oldStr.length() && newStr.compareTo(oldStr) < 0);
    }
}
