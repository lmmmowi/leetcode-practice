package com.lmmmowi.leetcode.p1512;

/**
 * @Author: lmmmowi
 * @Date: 2020/7/20
 * @Description: 1512.好数对的数目[https://leetcode-cn.com/problems/number-of-good-pairs/]
 */
public class Solution {

    public int numIdenticalPairs(int[] nums) {
        int[] numberCounts = new int[100];
        for (int num : nums) {
            numberCounts[num - 1]++;
        }

        int sum = 0;
        for (int numberCount : numberCounts) {
            if (numberCount > 1) {
                sum += (numberCount - 1) * numberCount / 2;
            }
        }
        return sum;
    }

}
