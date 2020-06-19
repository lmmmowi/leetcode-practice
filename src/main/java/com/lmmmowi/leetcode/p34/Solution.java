package com.lmmmowi.leetcode.p34;

/**
 * @Author: mowi
 * @Date: 2020/6/19
 * @Description: 34.在排序数组中查找元素的第一个和最后一个位置[https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] result = new Solution().searchRange(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public int[] searchRange(int[] nums, int target) {
        int left = find(nums, 0, nums.length - 1, target, LEFT);
        int right = find(nums, 0, nums.length - 1, target, RIGHT);
        return new int[]{left, right};
    }

    private int find(int[] nums, int head, int tail, int target, int direction) {
        if (head > tail) {
            return -1;
        }

        int mid = (head + tail) / 2;

        if (nums[mid] > target) {
            return find(nums, head, mid - 1, target, direction);
        } else if (nums[mid] < target) {
            return find(nums, mid + 1, tail, target, direction);
        }

        if (LEFT == direction) {
            if (mid > 0 && nums[mid - 1] == target) {
                return find(nums, head, mid - 1, target, direction);
            }
        } else {
            if (mid + 1 < nums.length && nums[mid + 1] == target) {
                return find(nums, mid + 1, tail, target, direction);
            }
        }

        return mid;
    }
}