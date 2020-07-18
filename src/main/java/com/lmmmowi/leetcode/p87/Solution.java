package com.lmmmowi.leetcode.p87;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/10
 * @Description: 87.扰乱字符串[https://leetcode-cn.com/problems/scramble-string/]
 */
public class Solution {

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }

        if (!hasSameCharacters(s1, s2)) {
            return false;
        }

        for (int i = 1; i <= len - 1; i++) {
            boolean scramble = isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, len), s2.substring(i, len));

            if (!scramble) {
                scramble = isScramble(s1.substring(0, i), s2.substring(len - i, len))
                        && isScramble(s1.substring(i, len), s2.substring(0, len - i));
            }

            if (scramble) {
                return true;
            }
        }

        return false;
    }

    private boolean hasSameCharacters(String s1, String s2) {
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a'] += 1;
            arr[s2.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
