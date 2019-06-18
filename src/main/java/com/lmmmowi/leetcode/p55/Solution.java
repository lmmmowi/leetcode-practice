package com.lmmmowi.leetcode.p55;

/**
 * @Author: mowi
 * @Date: 2019-06-18
 * @Description: 55.跳跃游戏[https://leetcode-cn.com/problems/jump-game/]
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int max = 0;

        if (nums.length > 0) {
            int cur = 0;
            while (cur >= 0) {
                if (cur + nums[cur] > max) {
                    max = cur + nums[cur];
                    cur = max;
                    if (max >= nums.length - 1) {
                        break;
                    }
                } else {
                    cur--;
                }
            }
        }

        return max >= nums.length - 1;
    }
}
