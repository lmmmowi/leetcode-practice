package com.lmmmowi.leetcode.p56;

import java.util.*;

/**
 * @Author: mowi
 * @Date: 2019-06-19
 * @Description: 56.合并区间[https://leetcode-cn.com/problems/merge-intervals/]
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        if (intervals.length > 0) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int prev = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[prev][1] >= intervals[i][0]) {
                    intervals[prev][1] = Math.max(intervals[prev][1], intervals[i][1]);
                } else {
                    list.add(intervals[prev]);
                    prev = i;
                }
            }
            list.add(intervals[prev]);
        }

        return list.toArray(new int[list.size()][2]);
    }

}
