package com.lmmmowi.leetcode.p239;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: lmmmowi
 * @Date: 2022/01/25
 * @Description: 239. 滑动窗口最大值[https://leetcode-cn.com/problems/sliding-window-maximum/]
 */
public class Solution {

    public static final int OFFSET = 10000;
    private final int[] counts = new int[20001];
    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int right = 0; right < nums.length; right++) {
            int left = right - k + 1;
            this.add(nums[right]);
            if (left >= 0) {
                if (left > 0) {
                    this.remove(nums[left - 1]);
                }
                result[left] = this.getMaxValue();
            }
        }
        return result;
    }

    private void add(int value) {
        if (counts[OFFSET + value] == 0) {
            priorityQueue.add(value);
        }
        counts[OFFSET + value]++;
    }

    private void remove(int value) {
        counts[OFFSET + value]--;
    }

    private int getMaxValue() {
        while (!priorityQueue.isEmpty()) {
            int value = priorityQueue.peek();
            if (counts[OFFSET + value] == 0) {
                priorityQueue.poll();
            } else {
                return value;
            }
        }
        throw new RuntimeException();
    }
}
