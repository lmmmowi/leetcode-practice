package com.lmmmowi.leetcode.p15;

import java.util.*;

/**
 * @Author: mowi
 * @Date: 2019-05-20
 * @Description: 15.三数之和[https://leetcode-cn.com/problems/3sum/]
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        // 将数组从小到大排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

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
            search(result, nums, l, m, r);
        }
        return result;
    }

    private void search(List<List<Integer>> result, int[] nums, int l, int m, int r) {
        int mv = nums[m];
        while (l < m && r > m) {
            int lv = nums[l];
            int rv = nums[r];

            boolean moveLeft;
            int sum = mv + lv + rv;
            if (sum == 0) {
                result.add(Arrays.asList(lv, mv, rv));

                moveLeft = m - l > r - m;
            } else {
                moveLeft = sum < 0;
            }

            if (moveLeft) {
                while (l < m && nums[++l] == lv) ;
            } else {
                while (r > m && nums[--r] == rv) ;
            }
        }
    }
}
