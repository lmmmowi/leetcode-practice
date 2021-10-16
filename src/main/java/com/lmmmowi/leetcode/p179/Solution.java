package com.lmmmowi.leetcode.p179;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/16
 * @Description: 179. 最大数[https://leetcode-cn.com/problems/largest-number/]
 */
public class Solution {

    public String largestNumber(int[] nums) {
        Comparator<String> comparator = (s1, s2) -> {
            int l1 = s1.length();
            int l2 = s2.length();
            int len = Math.max(l1, l2);
            for (int i = 0; i < len; i++) {
                if (i < l1 && i < l2) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    if (c1 > c2) {
                        return -1;
                    } else if (c1 < c2) {
                        return 1;
                    }
                } else {
                    long a = Long.parseLong(s1 + s2);
                    long b = Long.parseLong(s2 + s1);
                    return a > b ? -1 : 1;
                }
            }
            return 0;
        };

        String result = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted(comparator)
                .collect(Collectors.joining());
        return result.startsWith("0") ? "0" : result;
    }
}
