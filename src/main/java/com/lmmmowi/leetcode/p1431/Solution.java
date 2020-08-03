package com.lmmmowi.leetcode.p1431;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 11102942
 * @Date: 2020/8/3
 * @Description: 1431.拥有最多糖果的孩子[https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/]
 */
public class Solution {

    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            boolean result = candies[i] + extraCandies >= max;
            results.add(result);
        }
        return results;
    }
}
