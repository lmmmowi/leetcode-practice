package com.lmmmowi.leetcode.p2008;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2023/1/2
 * @Description: 2008. 出租车的最大盈利[https://leetcode.cn/problems/maximum-earnings-from-taxi/]
 */
public class Solution {

    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        List<int[]>[] lists = new List[n + 1];
        for (int[] ride : rides) {
            int end = ride[1];
            if (lists[end] == null) {
                lists[end] = new LinkedList<>();
            }
            lists[end].add(ride);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            if (lists[i] != null) {
                for (int[] ride : lists[i]) {
                    int start = ride[0];
                    int end = ride[1];
                    int tip = ride[2];

                    if (end == i) {
                        dp[i] = Math.max(dp[i], dp[start] + (end - start + tip));
                    }
                }
            }
        }

        return dp[n];
    }
}
