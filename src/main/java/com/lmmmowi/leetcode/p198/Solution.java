package com.lmmmowi.leetcode.p198;

/**
 * @Author: 11102942
 * @Date: 2020/8/3
 * @Description: 198.打家劫舍[https://leetcode-cn.com/problems/house-robber/]
 */
public class Solution {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        int steal = nums[1];
        int notSteal = nums[0];
        for (int i = 2; i < length; i++) {
            int newSteal = Math.max(steal, notSteal + nums[i]);
            int newNotSteal = Math.max(steal, notSteal);
            steal = newSteal;
            notSteal = newNotSteal;
        }
        return Math.max(steal, notSteal);
    }

}
