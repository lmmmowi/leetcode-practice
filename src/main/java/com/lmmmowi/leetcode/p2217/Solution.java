package com.lmmmowi.leetcode.p2217;

/**
 * @Author: mowi
 * @Date: 2022/7/5
 * @Description: 2217. 找到指定长度的回文数[https://leetcode.cn/problems/find-palindrome-with-fixed-length/]
 */
public class Solution {

    public long[] kthPalindrome(int[] queries, int intLength) {
        int from = (int) Math.pow(10, (intLength - 1) / 2);
        int limit = from * 10;
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int tag = from + queries[i] - 1;
            result[i] = tag >= limit ? -1 : getPalindrome(tag, intLength % 2 != 0);
        }
        return result;
    }

    private long getPalindrome(int tag, boolean isOdd) {
        long value = tag;
        if (isOdd) {
            tag /= 10;
        }
        while (tag > 0) {
            value = value * 10 + tag % 10;
            tag /= 10;
        }
        return value;
    }
}
