package com.lmmmowi.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mowi
 * @Date: 2019-05-11
 * @Description: 1.两数之和[https://leetcode-cn.com/problems/two-sum/]
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int size = (nums.length / 3 + 1) * 4;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(size);

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{i, index};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
