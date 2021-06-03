package com.lmmmowi.leetcode.p473;

import java.util.Arrays;

/**
 * @Author: lmmmowi
 * @Date: 2021/6/3
 * @Description: 473. 火柴拼正方形[https://leetcode-cn.com/problems/matchsticks-to-square/]
 */
public class Solution {

    public boolean makesquare(int[] matchsticks) {
        long totalLength = 0;
        for (int matchstick : matchsticks) {
            totalLength += matchstick;
        }

        if (totalLength % 4 > 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }

        long sideLength = totalLength / 4;
        if (matchsticks[0] > sideLength) {
            return false;
        }

        long curLength = matchsticks[0];
        matchsticks[0] = 0;
        return dfs(matchsticks, totalLength / 4, 0, curLength);
    }

    private boolean dfs(int[] matchsticks, long sideLength, int sideCount, long curLength) {
        if (curLength == sideLength) {
            sideCount++;
            curLength = 0L;

            if (sideCount == 4) {
                return true;
            }
        }

        int lastChosen = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            int length = matchsticks[i];
            if (length > 0 && length != lastChosen && curLength + length <= sideLength) {
                lastChosen = length;
                matchsticks[i] = 0;
                boolean ok = dfs(matchsticks, sideLength, sideCount, curLength + length);
                if (ok) {
                    return true;
                }
                matchsticks[i] = length;
            }
        }

        return false;
    }
}
