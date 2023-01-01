package com.lmmmowi.leetcode.p646;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lmmmowi
 * @Date: 2023/1/1
 * @Description: 646. 最长数对链[https://leetcode.cn/problems/maximum-length-of-pair-chain/]
 */
public class Solution {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[1]));

        int result = 0;
        int end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                end = pair[1];
                result++;
            }
        }
        return result;
    }
}
