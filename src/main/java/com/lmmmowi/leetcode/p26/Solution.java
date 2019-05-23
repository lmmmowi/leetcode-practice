package com.lmmmowi.leetcode.p26;

/**
 * @Author: mowi
 * @Date: 2019-05-23
 * @Description: 26.删除排序数组中的重复项[https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/]
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
