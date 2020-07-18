package com.lmmmowi.leetcode.p287;

/**
 * @Author: 11102942
 * @Date: 2020/7/18
 * @Description: 287.寻找重复数[https://leetcode-cn.com/problems/find-the-duplicate-number/]
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if (fast == slow) {
                fast = 0;
                while (fast != slow) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return fast;
            }
        }
    }
}
