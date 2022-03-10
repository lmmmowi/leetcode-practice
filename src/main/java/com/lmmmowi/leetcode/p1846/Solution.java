package com.lmmmowi.leetcode.p1846;

/**
 * @Author: mowi
 * @Date: 2022/3/10
 * @Description: 1846. 减小和重新排列数组后的最大元素[https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/]
 */
public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];
        for (int i : arr) {
            int val = Math.min(i, n);
            count[val]++;
        }

        int fast = 1;
        for (int slow = 1; slow <= n; slow++) {
            if (count[slow] > 0) {
                continue;
            }

            fast = Math.max(fast, slow + 1);
            while (fast <= n && count[fast] == 0) {
                fast++;
            }

            if (fast <= n) {
                count[fast]--;
                count[slow]++;
            } else {
                return slow - 1;
            }
        }

        return n;
    }
}
