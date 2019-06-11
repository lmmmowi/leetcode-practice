package com.lmmmowi.leetcode.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: mowi
 * @Date: 2019-06-11
 * @Description: 47.全排列 II[https://leetcode-cn.com/problems/permutations-ii/]
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        List<List<Integer>> result = new ArrayList<>();
        run(result, nums, used, new Stack<>(), 0);
        return result;
    }

    private void run(List<List<Integer>> result, int[] nums, boolean[] used, Stack<Integer> stack, int index) {
        if (index >= nums.length) {
            List<Integer> list = Arrays.asList(stack.toArray(new Integer[0]));
            result.add(list);
            return;
        }

        int lastUsed = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || nums[i] == lastUsed) {
                continue;
            }

            used[i] = true;
            stack.push(nums[i]);
            run(result, nums, used, stack, index + 1);
            stack.pop();
            used[i] = false;

            lastUsed = nums[i];
        }
    }
}
