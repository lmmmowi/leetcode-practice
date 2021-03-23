package com.lmmmowi.leetcode.p1675;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/23
 * @Description: 1675. 数组的最小偏移量[https://leetcode-cn.com/problems/minimize-deviation-in-array/]
 */
public class Solution {

    public int minimumDeviation(int[] nums) {
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt((Integer o) -> o).reversed());

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                nums[i] <<= 1;
            }

            min = Math.min(min, nums[i]);
            queue.add(nums[i]);
        }

        while (true) {
            int max = queue.poll();
            res = Math.min(res, max - min);

            if ((max & 1) == 1) {
                return res;
            }

            max >>= 1;
            min = Math.min(min, max);
            queue.add(max);
        }
    }
}
