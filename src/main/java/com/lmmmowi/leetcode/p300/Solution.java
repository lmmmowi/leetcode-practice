package com.lmmmowi.leetcode.p300;

/**
 * @Author: lmmmowi
 * @Date: 2020/9/9
 * @Description: 300.最长上升子序列[https://leetcode-cn.com/problems/longest-increasing-subsequence/]
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        int[] tails = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            int head = 0;
            int tail = maxLength;
            while (head <= tail) {
                int mid = (head + tail) / 2;
                if (mid == 0 || tails[mid] < nums[i]) {
                    head = mid + 1;
                } else {
                    tail = mid - 1;
                }
            }

            int length = head;
            tails[i + 1] = Integer.MAX_VALUE;
            tails[length] = Math.min(tails[length], nums[i]);
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
