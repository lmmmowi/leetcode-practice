package com.lmmmowi.lcof.p15;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/22
 * @Description: 剑指 Offer 15. 二进制中1的个数[https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/]
 */
public class Solution {

    public int hammingWeight(int n) {
        int k = 0;
        while (n != 0) {
            if ((1 & n) == 1) {
                k++;
            }
            n >>>= 1;
        }
        return k;
    }
}
