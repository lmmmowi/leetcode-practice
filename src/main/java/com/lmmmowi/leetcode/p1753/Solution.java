package com.lmmmowi.leetcode.p1753;

import java.util.Arrays;

/**
 * @Author: mowi
 * @Date: 2022/3/8
 * @Description: 1753. 移除石子的最大得分[https://leetcode-cn.com/problems/maximum-score-from-removing-stones/]
 */
public class Solution {

    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];

        int count1 = b - a;
        c -= count1;
        b -= count1;

        int count2 = Math.min(b, c - b);
        a -= count2;
        b -= count2;
        c -= count2 * 2;

        int count3 = a == 0 ? 0 : (a + b + c) / 2;

        return count1 + count2 * 2 + count3;
    }
}
