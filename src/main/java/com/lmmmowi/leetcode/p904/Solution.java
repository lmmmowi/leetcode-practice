package com.lmmmowi.leetcode.p904;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 11102942
 * @Date: 2021/1/16
 * @Description: 904.水果成篮[https://leetcode-cn.com/problems/fruit-into-baskets/]
 */
public class Solution {

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> baskets = new HashMap<>();

        int pointer = 0;
        int total = 0;
        int maxTotal = 0;
        for (int fruit : tree) {
            int fruitCount = baskets.getOrDefault(fruit, 0);
            if (fruitCount == 0 && baskets.size() >= 2) {
                while (true) {
                    total--;
                    int throwingFruit = tree[pointer++];
                    int leftCount = baskets.get(throwingFruit);
                    if (leftCount - 1 > 0) {
                        baskets.put(throwingFruit, leftCount - 1);
                    } else {
                        baskets.remove(throwingFruit);
                        break;
                    }
                }
            }

            baskets.put(fruit, fruitCount + 1);
            total++;
            maxTotal = Math.max(maxTotal, total);
        }

        return maxTotal;
    }
}
