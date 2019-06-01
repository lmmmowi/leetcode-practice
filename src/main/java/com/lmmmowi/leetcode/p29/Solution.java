package com.lmmmowi.leetcode.p29;

/**
 * @Author: mowi
 * @Date: 2019-06-01
 * @Description: 29.两数相除[https://leetcode-cn.com/problems/divide-two-integers/]
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        // 记录结果符号，将被除数和除数都转化为负数，避免过程中溢出
        boolean positive = dividend >= 0;
        dividend = -Math.abs(dividend);
        positive = divisor >= 0 == positive;
        divisor = -Math.abs(divisor);

        // 依次按照除数的2倍、4倍、8倍...构造数组
        int k = 0;
        int[] a = new int[33];
        int[] b = new int[33];
        while (k == 0 || (b[k - 1] < 0 && b[k - 1] >= dividend) || --k < 0) {
            a[k] = k == 0 ? 1 : (a[k - 1] << 1);
            b[k] = k == 0 ? divisor : (b[k - 1] << 1);
            k++;
        }

        // 尝试将被除数减去除数的N倍，如果够减，则将商增加N
        int quotient = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (dividend - b[i] <= 0) {
                dividend -= b[i];
                quotient += a[i];
            }
        }

        // 处理商溢出的情况
        if (quotient < 0 && positive) {
            return Integer.MAX_VALUE;
        }

        // 处理结果的符号
        return positive ? quotient : -quotient;
    }
}
