package com.lmmmowi.leetcode.p60;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 11102942
 * @Date: 2019/7/11
 * @Description: 60.第k个排列[https://leetcode-cn.com/problems/permutation-sequence/]
 */
public class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] * i;
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int pos = n - i;

            int m = (k - 1) / arr[pos - 1];
            sb.append(list.get(m));
            list.remove(m);
            k -= m * arr[pos - 1];
        }

        return sb.toString();
    }
}
