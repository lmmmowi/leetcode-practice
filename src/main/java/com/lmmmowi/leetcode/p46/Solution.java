package com.lmmmowi.leetcode.p46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: mowi
 * @Date: 2019-06-11
 * @Description: 46.全排列[https://leetcode-cn.com/problems/permutations/]
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
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

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            stack.push(nums[i]);
            run(result, nums, used, stack, index + 1);
            stack.pop();
            used[i] = false;
        }
    }
}
