package com.lmmmowi.leetcode.p457;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/25
 * @Description: 457.环形数组循环[https://leetcode-cn.com/problems/circular-array-loop/]
 */
public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        int VISITED = 0;
        int IN_LOOP = len;

        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] % len;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == VISITED) {
                continue;
            }

            int n = i;
            int flag = nums[i] > 0 ? 1 : -1;
            while (nums[n] * flag > 0) {
                int m = (n + nums[n] + len) % len;
                nums[n] = IN_LOOP;

                if (nums[m] == IN_LOOP) {
                    return true;
                } else if (nums[m] == VISITED || nums[m] * flag < 0) {
                    for (int j = 0; j < len; j++) {
                        if (nums[j] == IN_LOOP) {
                            nums[j] = VISITED;
                        }
                    }
                    break;
                } else {
                    n = m;
                }
            }
        }

        return false;
    }
}
