package com.lmmmowi.leetcode.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2019-06-06
 * @Description: 40.组合总和 II[https://leetcode-cn.com/problems/combination-sum-ii/]
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<Integer> newCandidates = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        int i = 0;
        int k = 0;
        while (i++ < candidates.length) {
            if (i < candidates.length && candidates[i - 1] == candidates[i]) {
                k++;
            } else {
                newCandidates.add(candidates[i - 1]);
                countList.add(k + 1);
                k = 0;
            }
        }

        return find(intListToArray(newCandidates), intListToArray(countList), target, 0);
    }

    private List<List<Integer>> find(int[] candidates, int counts[], int target, int start) {
        if (start >= candidates.length || target < candidates[start]) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            int k = 1;
            int curVal;
            while (k <= counts[i] && (curVal = candidates[i] * k) <= target) {
                if (curVal == target) {
                    result.add(fillList(new ArrayList<>(), k, candidates[i]));
                } else if (target - curVal > candidates[i]) {
                    List<List<Integer>> lists = find(candidates, counts, target - curVal, i + 1);
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

    private int[] intListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
