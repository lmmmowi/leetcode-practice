package com.lmmmowi.leetcode.p1371;

import java.util.Arrays;

/**
 * @Author: lmmmowi
 * @Date: 2022/12/2
 * @Description: 1371. 每个元音包含偶数次的最长子字符串[https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/]
 */
public class Solution {

    private static final int[] MASKS = new int[]{
            1, 0, 0, 0, 2, 0, 0, 0,         // abcdefgh
            4, 0, 0, 0, 0, 0, 8, 0,         // ijklmnop
            0, 0, 0, 0, 16, 0, 0, 0, 0, 0,  // qrstuvwxyz
    };

    public int findTheLongestSubstring(String s) {
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;

        int maxLen = 0;
        int flag = 0;
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            flag ^= MASKS[c - 'a'];

            if (pos[flag] >= 0) {
                maxLen = Math.max(maxLen, i - pos[flag]);
            } else {
                pos[flag] = i;
            }
        }

        return maxLen;
    }
}
