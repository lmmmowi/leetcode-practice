package com.lmmmowi.lcof.p3;

/**
 * @Author: 11102942
 * @Date: 2021/3/18
 * @Description: 剑指 Offer 03. 数组中重复的数字[https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/]
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        int[] m = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            if (m[nums[i]]++ > 0) {
                return nums[i];
            }
        }
        return -1;
    }
}
