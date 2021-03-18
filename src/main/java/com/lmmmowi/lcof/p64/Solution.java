package com.lmmmowi.lcof.p64;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/18
 * @Description: 剑指 Offer 64. 求1+2+…+n[https://leetcode-cn.com/problems/qiu-12n-lcof/]
 */
public class Solution {

    public int sumNums(int n) {
        int res = n;
        boolean flag = n > 0 && (res += sumNums(n - 1)) > 0;
        return res;
    }
}
