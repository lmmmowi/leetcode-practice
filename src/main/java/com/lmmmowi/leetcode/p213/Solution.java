package com.lmmmowi.leetcode.p213;

import java.util.Arrays;

/**
 * @Author: 11102942
 * @Date: 2020/8/3
 * @Description: 213.打家劫舍 II[https://leetcode-cn.com/problems/house-robber-ii/]
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int doRobFirst = nums[0] + doRob(nums, 2, nums.length - 1);
        int notRobFirst = doRob(nums, 1, nums.length);
        return Math.max(doRobFirst, notRobFirst);
    }

    private int doRob(int[] nums, int from, int to) {
        if (from > to) {
            return 0;
        } else {
            return simpleRob(Arrays.copyOfRange(nums, from, to));
        }
    }

    /**
     * 按照p198的打劫方式进行
     *
     * @param nums
     * @return
     */
    private int simpleRob(int[] nums) {
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
