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
        Map<Integer, List<Integer>> digitMap = new HashMap<>();
        for (int digit : digits) {
            int remainder = digit % 3;
            digitMap.computeIfAbsent(remainder, o -> new ArrayList<>()).add(digit);
        }

        int sum = Arrays.stream(digits).sum();
        int remainder = sum % 3;
        if (remainder == 0) {
            return digits;
        }

        List<Integer> list1 = digitMap.getOrDefault(1, Collections.emptyList());
        List<Integer> list2 = digitMap.getOrDefault(2, Collections.emptyList());
        int count1 = remainder == 1 ? 1 : 2;
        int count2 = remainder == 2 ? 1 : 2;

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        treeMap.put(count1, list1);
        treeMap.put(count2, list2);

        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            int count = entry.getKey();
            List<Integer> list = entry.getValue();
            if (list.size() >= count && count < digits.length) {
                Collections.sort(list);
                list.subList(0, count).clear();

                return digitMap.values().stream()
                        .flatMap(Collection::stream)
                        .mapToInt(Integer::intValue)
                        .toArray();
            }
        }
        return new int[0];
    }
}
