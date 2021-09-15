package com.lmmmowi.leetcode.p162;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/15
 * @Description: 162. 寻找峰值[https://leetcode-cn.com/problems/find-peak-element/]
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int head, int tail) {
        int i = (head + tail) / 2;
        int cur = nums[i];
        boolean greaterThanPrev = i == 0 || cur > nums[i - 1];
        boolean greaterThanNext = i >= nums.length - 1 || cur > nums[i + 1];
        if (greaterThanPrev && greaterThanNext) {
            return i;
        } else if (!greaterThanPrev && greaterThanNext) {
            return findPeakElement(nums, head, i - 1);
        } else {
            return findPeakElement(nums, i + 1, tail);
        }
    }
}
