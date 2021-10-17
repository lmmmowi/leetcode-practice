package com.lmmmowi.leetcode.p321;

/**
 * @Author: lmmmowi
 * @Date: 2020/10/12
 * @Description: 321. 拼接最大数 [https://leetcode-cn.com/problems/create-maximum-number/]
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = null;
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (i > nums1.length || j > nums2.length) {
                continue;
            }

            int[] pick1 = pick(nums1, i);
            int[] pick2 = pick(nums2, j);
            int[] merged = merge(pick1, pick2);
            max = max == null ? merged : compare(max, 0, merged, 0);
        }
        return max;
    }

    private int[] pick(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int n = nums.length;
        int m = n - k;

        for (int num : nums) {
            while (m > 0 && top >= 0) {
                if (stack[top] < num) {
                    top--;
                    m--;
                } else {
                    break;
                }
            }
            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                m--;
            }
        }

        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = nums1.length + nums2.length;
        int[] nums = new int[k];
        while (i + j < k) {
            boolean pickNums1;
            if (i >= nums1.length) {
                pickNums1 = false;
            } else if (j >= nums2.length) {
                pickNums1 = true;
            } else if (nums1[i] > nums2[j]) {
                pickNums1 = true;
            } else if (nums1[i] < nums2[j]) {
                pickNums1 = false;
            } else {
                int[] winner = compare(nums1, i, nums2, j);
                pickNums1 = winner == nums1;
            }

            if (pickNums1) {
                nums[i + j] = nums1[i];
                i++;
            } else {
                nums[i + j] = nums2[j];
                j++;
            }
        }
        return nums;
    }

    private int[] compare(int[] nums1, int i, int[] nums2, int j) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        while (i < len1 && j < len2) {
            if (nums1[i] > nums2[j]) {
                return nums1;
            } else if (nums1[i] < nums2[j]) {
                return nums2;
            } else {
                i++;
                j++;
            }
        }

        return i < len1 ? nums1 : nums2;
    }
}
