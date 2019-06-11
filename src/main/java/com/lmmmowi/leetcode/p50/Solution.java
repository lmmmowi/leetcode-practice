package com.lmmmowi.leetcode.p50;

/**
 * @Author: mowi
 * @Date: 2019-06-11
 * @Description: 50.Pow(x, n)[https://leetcode-cn.com/problems/powx-n/]
 */
public class Solution {

    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double result = 1;
        if (n < 0) {
            result = x;
            n -= 1;
        }
        return result * calc(x, n);
    }

    private double calc(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double t = calc(x, n / 2);
        return n % 2 == 1 ? x * t * t : t * t;
    }
}
