package com.lmmmowi.leetcode.p1979;

/**
 * @Author: mowi
 * @Date: 2022-07-31
 * @Description: 1979. 找出数组的最大公约数[https://leetcode.cn/problems/find-greatest-common-divisor-of-array/]
 */
public class Solution {

    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return findGCD(min, max);
    }

    private int findGCD(int smaller, int bigger) {
        int mod = bigger % smaller;
        if (mod == 0) {
            return smaller;
        } else {
            return findGCD(mod, smaller);
        }
    }
}
