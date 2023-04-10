package com.lmmmowi.leetcode.p201;

/**
 * @Author: lmmmowi
 * @Date: 2023/4/10
 * @Description: 201. 数字范围按位与[https://leetcode.cn/problems/bitwise-and-of-numbers-range/]
 */
public class Solution {

    public int rangeBitwiseAnd(int left, int right) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int eraser = -1 << i;

            if ((right & bit) == 0) {
                continue;
            }

            int a = (right & eraser) - 1;
            if (left <= a) {
                continue;
            }

            result |= bit;
        }

        return result;
    }
}
