package com.lmmmowi.leetcode.p274;

/**
 * @Author: lmmmowi
 * @Date: 2020/9/28
 * @Description: 274.H 指数[https://leetcode-cn.com/problems/h-index/]
 */
public class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int m = Math.min(n, citations[i]);
            arr[m]++;
        }

        int papers = 0;
        int maxIndex = 0;
        for (int i = n; i > 0; i--) {
            papers += arr[i];
            if (papers >= i) {
                maxIndex = Math.max(maxIndex, i);
            }
        }

        return maxIndex;
    }
}
