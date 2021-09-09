package com.lmmmowi.leetcode.p233;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/9
 * @Description: 233. 数字 1 的个数[https://leetcode-cn.com/problems/number-of-digit-one/]
 */
public class Solution {

    public int countDigitOne(int n) {
        // f[i]表示所有小于10^i的数中出现1的次数
        int[] f = new int[10];
        for (int i = 1; i < f.length; i++) {
            int t = i - 1;
            f[i] = 10 * f[t] + (int) Math.pow(10, t);
        }

        int count = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - '0';
            int t = s.length() - i - 1;

            count += k * f[t];

            if (k > 1) {
                count += (int) Math.pow(10, t);
            } else if (k == 1) {
                String suffix = s.substring(i + 1);
                int suffixCount = suffix.isEmpty() ? 0 : Integer.parseInt(suffix);
                count += suffixCount + 1;
            }
        }

        return count;
    }
}
