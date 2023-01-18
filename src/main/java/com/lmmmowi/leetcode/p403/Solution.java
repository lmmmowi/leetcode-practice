package com.lmmmowi.leetcode.p403;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lmmmowi
 * @Date: 2023/1/18
 * @Description: 403. 青蛙过河[https://leetcode.cn/problems/frog-jump/]
 */
public class Solution {

    public boolean canCross(int[] stones) {
        int n = stones.length;

        Map<Integer, Integer> stoneIndexMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            stoneIndexMap.put(stones[i], i);
        }

        int maxK = 1;
        boolean[][] dp = new boolean[n][n];
        dp[0][1] = true;

        for (int i = 0; i < n - 1; i++) {
            int temp = maxK;
            for (int step = 1; step <= temp; step++) {
                if (!dp[i][step]) {
                    continue;
                }

                int distance = stones[i] + step;
                Integer index = stoneIndexMap.get(distance);
                if (index == null) {
                    continue;
                }

                if (index == n - 1) {
                    return true;
                }

                dp[index][step - 1] = dp[index][step] = dp[index][step + 1] = true;
                maxK = Math.max(maxK, step + 1);
            }
        }

        return false;
    }
}
