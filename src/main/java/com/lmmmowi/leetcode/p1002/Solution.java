package com.lmmmowi.leetcode.p1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2021/5/10
 * @Description: 1002. 查找常用字符[https://leetcode-cn.com/problems/find-common-characters/]
 */
public class Solution {

    private static final int LETTER_NUM = 26;

    public List<String> commonChars(String[] A) {
        int[] globalCharCounts = new int[LETTER_NUM];
        Arrays.fill(globalCharCounts, Integer.MAX_VALUE);

        for (String s : A) {
            int[] charCounts = new int[LETTER_NUM];

            for (int i = 0; i < s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                charCounts[charIndex]++;
            }

            for (int i = 0; i < LETTER_NUM; i++) {
                globalCharCounts[i] = Math.min(globalCharCounts[i], charCounts[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < LETTER_NUM; i++) {
            for (int j = 0; j < globalCharCounts[i]; j++) {
                String letter = String.valueOf((char) ('a' + i));
                result.add(letter);
            }
        }
        return result;
    }
}
