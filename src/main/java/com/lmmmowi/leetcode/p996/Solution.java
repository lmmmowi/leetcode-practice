package com.lmmmowi.leetcode.p996;

import java.util.Arrays;

/**
 * @Author: 11102942
 * @Date: 2021/12/6
 * @Description: 996. 正方形数组的数目[https://leetcode-cn.com/problems/number-of-squareful-arrays/]
 */
public class Solution {

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        int[] counter = new int[1];
        travel(nums, 0, 0, counter);
        return counter[0];
    }

    private void travel(int[] nums, int step, int prev, int[] counter) {
        if (step == nums.length) {
            counter[0]++;
            return;
        }

        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value >= 0 && value != last) {
                if (step == 0 || isFullSquareNumber(value + prev)) {
                    nums[i] = -1;
                    travel(nums, step + 1, value, counter);
                    nums[i] = value;
                }
                last = nums[i];
            }
        }
    }

    private boolean isFullSquareNumber(int x) {
        int a = (int) Math.sqrt(x);
        return x == a * a;
    }
}
