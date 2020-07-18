package com.lmmmowi.leetcode.p75;

/**
 * @Author: lmmmowi
 * @Date: 2019/8/12
 * @Description: 75.颜色分类[https://leetcode-cn.com/problems/sort-colors/]
 */
public class Solution {

    public void sortColors(int[] nums) {
        int head = -1;
        int tail = nums.length;
        int i = 0;
        while (i < tail) {
            int v = nums[i];
            if (v == 0) {
                nums[i] = nums[++head];
                nums[head] = v;
                i++;
            } else if (v == 2) {
                nums[i] = nums[--tail];
                nums[tail] = v;
            } else {
                i++;
            }
        }
    }

}
