package com.lmmmowi.leetcode.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2019-06-06
 * @Description: 39.组合总和[https://leetcode-cn.com/problems/combination-sum/]
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return find(candidates, target, 0);
    }

    private List<List<Integer>> find(int[] candidates, int target, int start) {
        if (start >= candidates.length || target < candidates[start]) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            int k = 1;
            int curVal;
            while ((curVal = candidates[i] * k) <= target) {
                if (curVal == target) {
                    result.add(fillList(new ArrayList<>(), k, candidates[i]));
                } else if (target - curVal > candidates[i]) {
                    List<List<Integer>> lists = find(candidates, target - curVal, i + 1);
                    for (List<Integer> list : lists) {
                        result.add(fillList(list, k, candidates[i]));
                    }
                }

                k++;
            }
        }
        return result;
    }

    private List<Integer> fillList(List<Integer> list, int k, int val) {
        for (int i = 0; i < k; i++) {
            list.add(0, val);
        }
        return list;
    }
}
