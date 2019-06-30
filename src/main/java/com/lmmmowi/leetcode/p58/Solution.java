package com.lmmmowi.leetcode.p58;

/**
 * @Author: mowi
 * @Date: 2019/6/30
 * @Description: 58.最后一个单词的长度[https://leetcode-cn.com/problems/length-of-last-word/]
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int lastWordLength = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (n > 0) {
                    lastWordLength = n;
                    n = 0;
                }
            } else {
                n++;
            }
        }
        return n > 0 ? n : lastWordLength;
    }
}
