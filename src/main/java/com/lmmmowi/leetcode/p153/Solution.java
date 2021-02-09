package com.lmmmowi.leetcode.p153;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/9
 * @Description: 153.寻找旋转排序数组中的最小值[https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/]
 */
public class Solution {

    public int findMin(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        int mid;

        while (true) {
            if (tail - head <= 1) {
                return Math.min(nums[head], nums[tail]);
            }

            mid = (head + tail) / 2;
            if (nums[head] > nums[mid]) {
                tail = mid;
            } else if (nums[tail] < nums[mid]) {
                head = mid;
            } else {
                return nums[head];
            }
        }
    }
}
