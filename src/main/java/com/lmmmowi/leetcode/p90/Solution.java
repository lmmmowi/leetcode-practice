package com.lmmmowi.leetcode.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: lmmmowi
 * @Date: 2020/12/30
 * @Description: 90.子集 II[https://leetcode-cn.com/problems/subsets-ii/]
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        this.find(nums, 0, new Stack<>(), results);
        return results;
    }

    private void find(int[] nums, int index, Stack<Integer> stack, List<List<Integer>> results) {
        results.add(new ArrayList<>(stack));
        if (index >= nums.length) {
            return;
        }

        Integer chosenNum = null;
        for (int i = index; i < nums.length; i++) {
            Integer num = nums[i];
            if (num.equals(chosenNum)) {
                continue;
            }

            chosenNum = num;
            stack.add(num);
            this.find(nums, i + 1, stack, results);
            stack.remove(num);
        }
    }
}
