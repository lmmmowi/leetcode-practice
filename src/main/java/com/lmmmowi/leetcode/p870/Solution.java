package com.lmmmowi.leetcode.p870;

import java.util.*;

/**
 * @Author: mowi
 * @Date: 2022/5/30
 * @Description: 870. 优势洗牌[https://leetcode.cn/problems/advantage-shuffle/]
 */
public class Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Queue<Integer> queueNums1 = new LinkedList<>();
        Queue<Integer> remaining = new LinkedList<>();

        Arrays.sort(nums1);
        for (int num : nums1) {
            queueNums1.add(num);
        }

        int[] arr = nums2.clone();
        Arrays.sort(arr);

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int num : arr) {
            Queue<Integer> queue = map.computeIfAbsent(num, o -> new LinkedList<>());
            while (!queueNums1.isEmpty()) {
                int val = queueNums1.poll();
                if (val > num) {
                    queue.add(val);
                    break;
                } else {
                    remaining.add(val);
                }
            }
        }

        int[] result = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            Queue<Integer> queue = map.get(nums2[i]);
            result[i] = queue.isEmpty() ? remaining.poll() : queue.poll();
        }
        return result;
    }
}
