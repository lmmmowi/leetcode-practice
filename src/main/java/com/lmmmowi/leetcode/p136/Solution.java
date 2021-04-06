package com.lmmmowi.leetcode.p136;

/**
 * @Author: lmmmowi
 * @Date: 2021/4/6
 * @Description: 136. 只出现一次的数字[https://leetcode-cn.com/problems/single-number/]
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r = r ^ nums[i];
        }
        return r;
    }
}
