package com.lmmmowi.leetcode.p315;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/18
 * @Description: 315.计算右侧小于当前元素的个数[https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/]
 */
public class Solution {

    private int[] result;
    private int[] index;
    private int[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        result = new int[len];
        index = new int[len];
        temp = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = temp[i] = i;
        }

        mergeSort(nums, 0, len - 1);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private void mergeSort(int[] nums, int head, int tail) {
        if (head >= tail) {
            return;
        }

        int m = (head + tail) / 2;
        mergeSort(nums, head, m);
        mergeSort(nums, m + 1, tail);

        int size = tail - head + 1;
        int lptr = head, rptr = m + 1;
        for (int i = 0; i < size; i++) {
            if (rptr > tail || (lptr <= m && nums[index[lptr]] <= nums[index[rptr]])) {
                int smallerCount = rptr - (m + 1);
                result[index[lptr]] += smallerCount;

                temp[head + i] = index[lptr++];
            } else {
                temp[head + i] = index[rptr++];
            }
        }
        System.arraycopy(temp, head, index, head, size);
    }
}
