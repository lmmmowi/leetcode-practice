package com.lmmmowi.leetcode.p354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lmmmowi
 * @Date: 2023/5/8
 * @Description: 354. 俄罗斯套娃信封问题[https://leetcode.cn/problems/russian-doll-envelopes/]
 */
public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        Comparator<int[]> comparator = Comparator
                .comparingInt((int[] arr) -> arr[0])
                .thenComparingInt((int[] arr) -> -arr[1]);
        Arrays.sort(envelopes, comparator);

        int[] nums = Arrays.stream(envelopes).mapToInt(arr -> arr[1]).toArray();
        return lengthOfLIS(nums);
    }

    private int lengthOfLIS(int[] nums) {
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
