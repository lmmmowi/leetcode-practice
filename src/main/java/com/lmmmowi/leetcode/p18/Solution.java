package com.lmmmowi.leetcode.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2019-05-28
 * @Description: 18.四数之和[https://leetcode-cn.com/problems/4sum/]
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 将数组从小到大排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // 假设符合条件的四个下标为（l,m,n,r），遍历m和n
        int head = 0, tail = nums.length - 1;
        for (int m = head + 1; m < tail - 1; m++) {
            int l = head;
            // 特别注意此处两个if判断，可以避免出现重复的组合
            if (m > head + 1 && nums[m] == nums[m - 1]) {
                if (nums[m] == nums[m - 2]) {
                    continue;
                }
                l = m - 1;
            }

            for (int n = tail - 1; n > m; n--) {
                int r = tail;
                // 特别注意此处两个if判断，可以避免出现重复的组合
                if (n < tail - 1 && nums[n] == nums[n + 1]) {
                    if (nums[n] == nums[n + 2]) {
                        continue;
                    }
                    r = n + 1;
                }

                // l和r从数组两端向中间缩进，并记录下符合条件的组合
                search(result, nums, target, l, m, n, r);
            }
        }
        return result;
    }

    private void search(List<List<Integer>> result, int[] nums, int target, int l, int m, int n, int r) {
        int mv = nums[m];
        int nv = nums[n];

        while (l < m && r > n) {
            int lv = nums[l];
            int rv = nums[r];

            boolean moveLeft;
            int sum = mv + nv + lv + rv;
            if (sum == target) {
                result.add(Arrays.asList(lv, mv, nv, rv));
                moveLeft = m - l > r - n;
            } else {
                moveLeft = sum < target;
            }

            if (moveLeft) {
                while (l < m && nums[++l] == lv) ;
            } else {
                while (r > n && nums[--r] == rv) ;
            }
        }
    }
}
