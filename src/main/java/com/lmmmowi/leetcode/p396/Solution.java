package com.lmmmowi.leetcode.p396;

/**
 * @Author: mowi
 * @Date: 2022/2/15
 * @Description: 396. 旋转函数[https://leetcode-cn.com/problems/rotate-function/]
 */
public class Solution {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int max = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            max = Math.max(max, f);
        }
        return max;
    }
}
