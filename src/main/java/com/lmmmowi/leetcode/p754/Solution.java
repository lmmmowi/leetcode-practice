package com.lmmmowi.leetcode.p754;

/**
 * @Author: lmmmowi
 * @Date: 2021/5/26
 * @Description: 754. 到达终点数字[https://leetcode-cn.com/problems/reach-a-number/]
 */
public class Solution {

    public int reachNumber(int target) {
        target = Math.abs(target);

        int n = 1;
        int cur = 0;
        while (cur < target) {
            cur += n++;
        }

        if ((target - cur) % 2 == 0) {
            return n - 1;
        } else if (n % 2 == 1) {
            return n;
        } else {
            return n + 1;
        }
    }
}
