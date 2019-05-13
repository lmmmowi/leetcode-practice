package com.lmmmowi.leetcode.p3;

import java.util.BitSet;

/**
 * @Author: mowi
 * @Date: 2019-05-13
 * @Description: 3.无重复字符的最长子串[https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/]
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        BitSet bitSet = new BitSet(256);
        int length = s.length();
        int max = 0;
        int left = -1;
        int right = -1;

        while (right + 1 < length) {
            // 滑动窗口
            left++;
            right++;

            // 子串满足条件
            if (isValid(s, left, right, bitSet)) {
                // 更新最长子串长度
                max = right - left + 1;

                // 扩展窗口
                left--;
            }
        }

        return max;
    }

    private boolean isValid(String s, int begin, int end, BitSet bitSet) {
        bitSet.clear();
        for (int i = begin; i <= end; i++) {
            char c = s.charAt(i);
            if (bitSet.get(c)) {
                return false;
            } else {
                bitSet.set(c);
            }
        }
        return true;
    }
}
