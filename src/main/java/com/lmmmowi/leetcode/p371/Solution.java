package com.lmmmowi.leetcode.p371;

/**
 * @Author: mowi
 * @Date: 2022/5/30
 * @Description: 371. 两整数之和[https://leetcode.cn/problems/sum-of-two-integers/]
 */
public class Solution {

    public int getSum(int a, int b) {
        while (true) {
            int andVal = a & b;
            if (andVal == 0) {
                return a | b;
            } else {
                a = a ^ b;
                b = andVal << 1;
            }
        }
    }
}
