package com.lmmmowi.leetcode.p526;

import java.util.Arrays;

/**
 * @Author: mowi
 * @Date: 2023/2/10
 * @Description: 526. 优美的排列[https://leetcode.cn/problems/beautiful-arrangement/]
 */
public class Solution {

    public int countArrangement(int n) {
        int[] cache = new int[1 << n];
        Arrays.fill(cache, -1);
        return dfs(1, n, 0, cache);
    }

    private int dfs(int index, int n, int mask, int[] cache) {
        if (index > n) {
            return 1;
        }

        if (cache[mask] >= 0) {
            return cache[mask];
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) > 0) {
                continue;
            }

            boolean valid = i >= index ? i % index == 0 : index % i == 0;
            if (!valid) {
                continue;
            }

            mask |= bit;
            count += dfs(index + 1, n, mask, cache);
            mask &= ~bit;
        }
        return cache[mask] = count;
    }
}
