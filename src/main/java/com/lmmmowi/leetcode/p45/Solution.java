package com.lmmmowi.leetcode.p45;

/**
 * @Author: mowi
 * @Date: 2019-06-11
 * @Description: 45.跳跃游戏 II[https://leetcode-cn.com/problems/jump-game-ii/]
 */
public class Solution {

    public int jump(int[] nums) {
        int len = nums.length - 1;
        int jump = 0;
        int range = 0;
        int index = 0;
        int tempRange = 0;

        while (index < len) {
            // 遍历index到range，测量出新的最大到达范围tempRange
            tempRange = Math.max(tempRange, Math.min(index + nums[index], len));

            if (index == range) {
                // 记录第jump跳能到达的最大范围是range
                jump++;
                range = tempRange;
            }

            index++;
        }

        return jump;
    }
}
