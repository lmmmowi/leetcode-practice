package com.lmmmowi.leetcode.p520;

/**
 * @Author: mowi
 * @Date: 2023/2/10
 * @Description: 520. 检测大写字母[https://leetcode.cn/problems/detect-capital/]
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        boolean allowUpperCase = true;
        boolean allowLowerCase = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isUpperCase(c)) {
                if (!allowUpperCase) {
                    return false;
                }
                if (i == 1) {
                    allowLowerCase = false;
                }
            } else {
                if (!allowLowerCase) {
                    return false;
                }
                allowUpperCase = false;
            }
        }
        return true;
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
