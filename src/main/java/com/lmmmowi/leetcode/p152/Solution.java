package com.lmmmowi.leetcode.p152;

/**
 * @Author: lmmmowi
 * @Date: 2020/7/7
 * @Description: 152.乘积最大子数组[https://leetcode-cn.com/problems/maximum-product-subarray/]
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int lastMax, lastMin, result;
        lastMax = lastMin = result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(nums[i] * lastMax, nums[i] * lastMin);
            int min = Math.min(nums[i] * lastMax, nums[i] * lastMin);

            lastMax = Math.max(max, nums[i]);
            lastMin = Math.min(min, nums[i]);

            result = Math.max(result, lastMax);
        }

        return result;
    }
}
