package com.lmmmowi.leetcode.p139;

import java.util.List;

/**
 * @Author: 11102942
 * @Date: 2020/7/4
 * @Description: 139.单词拆分[https://leetcode-cn.com/problems/word-break/submissions/]
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            boolean match = false;
            for (String word : wordDict) {
                int beginIndex = i - word.length();
                if (beginIndex < 0 || !flags[beginIndex]) {
                    continue;
                }

                String temp = s.substring(beginIndex, i);
                if (temp.equals(word)) {
                    match = true;
                    break;
                }
            }
            flags[i] = match;
        }

        return flags[s.length()];
    }
}
