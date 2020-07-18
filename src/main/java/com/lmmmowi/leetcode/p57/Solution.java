package com.lmmmowi.leetcode.p57;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/12
 * @Description: 57.插入区间[https://leetcode-cn.com/problems/insert-interval/]
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;

        int a = 0;
        while (a < length && intervals[a][1] < newInterval[0]) {
            a++;
        }

        int b = length - 1;
        while (b >= 0 && intervals[b][0] > newInterval[1]) {
            b--;
        }

        int[][] result = new int[length - (b - a)][];
        int k = 0;
        for (int i = 0; i < a; i++) {
            result[k++] = intervals[i];
        }
        if (a <= b) {
            result[k++] = new int[]{Math.min(intervals[a][0], newInterval[0]), Math.max(intervals[b][1], newInterval[1])};
        } else {
            result[k++] = newInterval;
        }
        for (int i = b + 1; i < length; i++) {
            result[k++] = intervals[i];
        }

        return result;
    }
}
