package com.lmmmowi.leetcode.p1374;

/**
 * @Author: mowi
 * @Date: 2022/5/31
 * @Description: 1374. 生成每种字符都是奇数个的字符串[https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/]
 */
public class Solution {

    public String generateTheString(int n) {
        int m = n;
        if (n % 2 == 0) {
            m = n / 2;
            if (m % 2 == 0) {
                m = m + 1;
            }
        }

        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = i < m ? 'a' : 'b';
        }
        return new String(chars);
    }
}
