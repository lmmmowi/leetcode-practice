package com.lmmmowi.leetcode.p53;

/**
 * @Author: mowi
 * @Date: 2019-06-07
 * @Description: 53.最大子序和[https://leetcode-cn.com/problems/maximum-subarray/]
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public int maxSubArray(int[] nums) {
        int max, record;
        max = record = nums[0];
        for (int i = 1; i < nums.length; i++) {
            record = Math.max(record + nums[i], nums[i]);
            max = Math.max(max, record);
        }
        return max;
    }
}
