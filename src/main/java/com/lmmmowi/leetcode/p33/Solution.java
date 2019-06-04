package com.lmmmowi.leetcode.p33;

/**
 * @Author: mowi
 * @Date: 2019-06-04
 * @Description: 33.搜索旋转排序数组[https://leetcode-cn.com/problems/search-in-rotated-sorted-array/]
 */
public class Solution {

    public int search(int[] nums, int target) {
        return search(nums, target, nums.length > 0 && nums[0] <= nums[nums.length - 1], 0, nums.length - 1);
    }

    public int search(int[] nums, int target, boolean sorted, int start, int end) {
        if (start > end) {
            return -1;
        }

        // 比较中间数
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        // 如果是正常升序
        if (sorted) {
            if (target >= nums[start] && target <= nums[end]) {
                // 正常二分查找
                if (target < nums[mid]) {
                    return search(nums, target, true, start, mid - 1);
                } else {
                    return search(nums, target, true, mid + 1, end);
                }
            } else {
                return -1;
            }
        }
        // 如果是反转序列
        else {
            int index = search(nums, target, mid - 1 >= 0 && nums[start] <= nums[mid - 1], start, mid - 1);
            if (index == -1) {
                index = search(nums, target, mid + 1 < nums.length && nums[mid + 1] <= nums[end], mid + 1, end);
            }
            return index;
        }
    }
}
