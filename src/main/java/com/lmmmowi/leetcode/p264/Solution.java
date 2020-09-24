package com.lmmmowi.leetcode.p264;

/**
 * @Author: 11102942
 * @Date: 2020/9/24
 * @Description: 264.丑数 II[https://leetcode-cn.com/problems/ugly-number-ii/]
 */
public class Solution {

    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[1690];
        uglyNumbers[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int confirmed = 1;
        while (confirmed < n) {
            int v2 = uglyNumbers[p2] * 2;
            int v3 = uglyNumbers[p3] * 3;
            int v5 = uglyNumbers[p5] * 5;

            int min = Math.min(v2, Math.min(v3, v5));
            uglyNumbers[confirmed++] = min;

            if (min == v2) {
                p2++;
            }

            if (min == v3) {
                p3++;
            }

            if (min == v5) {
                p5++;
            }
        }

        return uglyNumbers[n - 1];
    }
}
