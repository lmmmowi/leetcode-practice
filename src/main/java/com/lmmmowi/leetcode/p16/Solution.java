package com.lmmmowi.leetcode.p16;

import java.util.Arrays;

/**
 * @Author: mowi
 * @Date: 2019/5/26
 * @Description: 16.最接近的三数之和[https://leetcode-cn.com/problems/3sum-closest/]
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        // 将数组从小到大排序
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE - Math.abs(target);

        // 假设符合条件的三个下标为（l,m,r），依次从1到length-1遍历m
        for (int m = 1; m < nums.length - 1; m++) {
            // 特别注意此处两个if判断，可以避免出现重复的组合
            int l = 0;
            if (m > 1 && nums[m] == nums[m - 1]) {
                if (nums[m] == nums[m - 2]) {
                    continue;
                }
                l = m - 1;
            }

            int r = nums.length - 1;

            // l和r从数组两端向中间缩进，并记录下符合条件的组合
            result = search(result, nums, target, l, m, r);
        }
        return result;
    }

    private int search(int result, int[] nums, int target, int l, int m, int r) {
        int min = Math.abs(result - target);
        int mv = nums[m];
        while (l < m && r > m) {
            int lv = nums[l];
            int rv = nums[r];

            boolean moveLeft;
            int sum = mv + lv + rv;
            int tmp = Math.abs(sum - target);
            if (tmp < min) {
                result = sum;
                min = tmp;
            }

            if (tmp == 0) {
                break;
            } else {
                moveLeft = sum - target < 0;
            }

            if (moveLeft) {
                while (l < m && nums[++l] == lv) ;
            } else {
                while (r > m && nums[--r] == rv) ;
            }
        }
        return result;
    }
}
