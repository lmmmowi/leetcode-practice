package com.lmmmowi.leetcode.p187;

import java.util.*;

/**
 * @Author: 11102942
 * @Date: 2020/8/25
 * @Description: 187.重复的DNA序列[https://leetcode-cn.com/problems/repeated-dna-sequences/]
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        int subStrLen = 10;
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Map<Character, Integer> charMap = new HashMap<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            charMap.put(chars[i], i);
        }

        if (s.length() <= subStrLen) {
            return Collections.emptyList();
        }

        int mask = 0;
        int bits = 0;
        for (int i = 0; i < subStrLen; i++) {
            char c = s.charAt(i);
            bits = (bits << 2) + charMap.get(c);
            mask = (mask << 2) + 3;
        }

        char[] flags = new char[1 << 2 * subStrLen];
        flags[bits] += 1;

        Set<String> result = new HashSet<>();
        for (int i = subStrLen; i < s.length(); i++) {
            char c = s.charAt(i);
            bits = ((bits << 2) & mask) + charMap.get(c);
            flags[bits] += 1;

            if (flags[bits] > 1) {
                String subStr = s.substring(i + 1 - subStrLen, i + 1);
                result.add(subStr);
            }
        }

        return new ArrayList<>(result);
    }
}
