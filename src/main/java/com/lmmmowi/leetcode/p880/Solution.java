package com.lmmmowi.leetcode.p880;

/**
 * @Author: mowi
 * @Date: 2022/7/5
 * @Description: 880. 索引处的解码字符串[https://leetcode.cn/problems/decoded-string-at-index/]
 */
public class Solution {

    public String decodeAtIndex(String s, int k) {
        return decodeAtIndex(s, k, 0, 0);
    }

    public String decodeAtIndex(String s, int k, int i, long prevLen) {
        char c = s.charAt(i);
        boolean isNumber = c >= '0' && c <= '9';
        long curLen = isNumber ? prevLen * (c - '0') : prevLen + 1;

        if (curLen < k) {
            return decodeAtIndex(s, k, i + 1, curLen);
        }

        if (isNumber) {
            long mod = k % prevLen;
            long newK = mod == 0 ? prevLen : mod;
            return decodeAtIndex(s, (int) newK, 0, 0);
        }

        return String.valueOf(c);
    }
}
