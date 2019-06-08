package com.lmmmowi.leetcode.p41;

/**
 * @Author: mowi
 * @Date: 2019-06-08
 * @Description: 41.缺失的第一个正数[https://leetcode-cn.com/problems/first-missing-positive/]
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 先查找数组中是否包含1，如果不包含，则结果为1
        boolean hasOne = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            }
        }
        if (!hasOne) {
            return 1;
        }

        // 把数组中小于1的数，以及大于n的数都设为1（第一个缺失的正数一定小于等于n+1，其中n+1的情况最后会考虑）
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // 由于题目要求使用常数级别的空间，所以不能单独开辟数组记录数字是否存在
        // 所以我们在原数组上，把num[k]设为负数来标识数字k存在
        for (int i = 0; i < n; i++) {
            int k = Math.abs(nums[i]);
            nums[k - 1] = -Math.abs(nums[k - 1]);
        }

        // 遍历找到num[i]不为负数的i，即为第一个缺失正数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
