package com.lmmmowi.leetcode.p434;

/**
 * @Author: lmmmowi
 * @Date: 2021/4/6
 * @Description: 434. 字符串中的单词数[https://leetcode-cn.com/problems/number-of-segments-in-a-string/]
 */
public class Solution {

    public int countSegments(String s) {
        int count = 0;
        int characters = 0;
        int length = s.length();
        for (int i = 0; i <= length; i++) {
            char c = i < length ? s.charAt(i) : ' ';
            if (c != ' ') {
                characters++;
            } else {
                if (characters > 0) {
                    count++;
                }
                characters = 0;
            }
        }

        return count;
    }
}
