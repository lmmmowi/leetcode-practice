package com.lmmmowi.leetcode.p523;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mowi
 * @Date: 2019-05-21
 * @Description: 523.连续的子数组和[https://leetcode-cn.com/problems/continuous-subarray-sum/]
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        // 特殊处理k=0的情况
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                // 如果遇到连续的0，则返回true
                if (nums[i] + nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        // modMap用来保存mod第一次出现的下标
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);

        k = Math.abs(k);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;

            // 如果遇到相同的mod，且下标间距大于1，则返回true
            Integer lastSameModPos = modMap.get(mod);
            if (lastSameModPos != null && i - lastSameModPos > 1) {
                return true;
            }
            modMap.putIfAbsent(mod, i);
        }

        return false;
    }
}
