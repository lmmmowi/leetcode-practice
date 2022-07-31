package com.lmmmowi.leetcode.p1759;


/**
 * @Author: mowi
 * @Date: 2022/07/31
 * @Description: 1759. 统计同构子字符串的数目[https://leetcode.cn/problems/count-number-of-homogenous-substrings/]
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int countHomogenous(String s) {
        char last = 0;
        int times = 0;
        int count = 0;

        for (int i = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : 0;
            if (c != last) {
                count = (int) ((count + (times + 1L) * times / 2 % MOD ) % MOD);
                times = 0;
            }

            last = c;
            times++;
        }

        return count;
    }
}
