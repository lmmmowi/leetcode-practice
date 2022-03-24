package com.lmmmowi.leetcode.p1363;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: mowi
 * @Date: 2022/3/24
 * @Description: 1363. 形成三的最大倍数[https://leetcode-cn.com/problems/largest-multiple-of-three/]
 */
public class Solution {

    public String largestMultipleOfThree(int[] digits) {
        digits = tryRemove(digits);
        if (digits.length == 0) {
            return "";
        }

        List<Integer> digitList = Arrays.stream(digits).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return digitList.get(0) == 0 ? "0" : digitList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private int[] tryRemove(int[] digits) {
        int sum = Arrays.stream(digits).sum();
        int remainder = sum % 3;
        if (remainder == 0) {
            return digits;
        }

        Map<Integer, List<Integer>> digitMap = Arrays.stream(digits).boxed().collect(Collectors.groupingBy(o -> o % 3));
        int[] arr = remainder == 1 ? new int[]{1, 2} : new int[]{2, 1};
        for (int r : arr) {
            List<Integer> list = digitMap.getOrDefault(r, Collections.emptyList());
            int count = r == remainder ? 1 : 2;

            if (list.size() >= count && count < digits.length) {
                Collections.sort(list);
                list.subList(0, count).clear();
                return digitMap.values().stream().flatMap(Collection::stream).mapToInt(Integer::intValue).toArray();
            }
        }
        return new int[0];
    }
}
