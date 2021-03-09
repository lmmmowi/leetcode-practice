package com.lmmmowi.leetcode.p451;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/2
 * @Description: 451.根据字符出现频率排序[https://leetcode-cn.com/problems/sort-characters-by-frequency/]
 */
public class Solution {

    public String frequencySort(String s) {
        int[] counts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c]++;
        }

        Character[] characters = new Character[128];
        for (char i = 0; i < characters.length; i++) {
            characters[i] = i;
        }
        Arrays.sort(characters, Comparator.comparingInt((Character c) -> counts[c]).reversed());

        StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            int count = counts[c];
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    sb.append(c);
                }
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
