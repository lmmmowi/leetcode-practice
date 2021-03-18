package com.lmmmowi.lcof.p62;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/18
 * @Description: 剑指 Offer 62. 圆圈中最后剩下的数字[https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/]
 */
public class Solution {

    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }
}
