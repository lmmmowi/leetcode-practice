package com.lmmmowi.leetcode.p313;

/**
 * @Author: 11102942
 * @Date: 2020/10/19
 * @Description: 313.超级丑数[https://leetcode-cn.com/problems/super-ugly-number/]
 */
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int size = 1;

        while (size < n) {
            int minValue = Integer.MAX_VALUE;
            int pointerIndex = -1;

            for (int i = 0; i < primes.length; i++) {
                int value = primes[i] * uglyNumbers[pointers[i]];
                while (value <= uglyNumbers[size - 1]) {
                    value = primes[i] * uglyNumbers[++pointers[i]];
                }

                if (value < minValue) {
                    minValue = value;
                    pointerIndex = i;
                }
            }

            uglyNumbers[size++] = minValue;
            pointers[pointerIndex]++;
        }

        return uglyNumbers[n - 1];
    }
}
