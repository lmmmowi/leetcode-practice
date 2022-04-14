package com.lmmmowi.leetcode.p342;

/**
 * @Author: lmmmowi
 * @Date: 2022/4/14
 * @Description: 342. 4的幂[https://leetcode-cn.com/problems/power-of-four/]
 */
public class Solution {

    public boolean isPowerOfFour(int n) {
        while (n > 0 && (n & 3) == 0) {
            n >>>= 2;
        }
        return n == 1;
    }
}
