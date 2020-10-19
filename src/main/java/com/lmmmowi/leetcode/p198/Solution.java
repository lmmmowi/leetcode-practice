package com.lmmmowi.leetcode.p198;

/**
 * @Author: lmmmowi
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

        int r = nums[1];
        int nr = nums[0];
        for (int i = 2; i < length; i++) {
            int newSteal = nr + nums[i];
            int newNotSteal = Math.max(r, nr);
            r = newSteal;
            nr = newNotSteal;
        }
        return Math.max(r, nr);
    }

}
