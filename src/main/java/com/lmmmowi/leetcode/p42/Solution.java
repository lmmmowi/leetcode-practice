package com.lmmmowi.leetcode.p42;

/**
 * @Author: mowi
 * @Date: 2019-06-09
 * @Description: 42.接雨水[https://leetcode-cn.com/problems/trapping-rain-water/]
 */
public class Solution {

    public int trap(int[] height) {
        int total = 0;
        int n = height.length;

        if (n > 0) {
            int[] l = new int[n], r = new int[n];

            l[0] = -1;
            for (int i = 1; i < n; i++) {
                l[i] = Math.max(l[i - 1], height[i - 1]);
            }

            r[n - 1] = -1;
            for (int i = n - 2; i >= 0; i--) {
                r[i] = Math.max(r[i + 1], height[i + 1]);
            }

            for (int i = 0; i < n; i++) {
                int t = Math.min(l[i], r[i]);
                if (t > height[i]) {
                    total += t - height[i];
                }
            }
        }

        return total;
    }
}
