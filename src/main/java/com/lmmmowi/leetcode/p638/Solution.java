package com.lmmmowi.leetcode.p638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/9
 * @Description: 638.大礼包[https://leetcode-cn.com/problems/shopping-offers/]
 */
public class Solution {

    private Map<List<Integer>, Integer> cache = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minPrice = calculatePrice(price, needs);
        return tryUseSpecial(minPrice, price, special, needs);
    }

    private int tryUseSpecial(int currentPrice, List<Integer> price, List<List<Integer>> specialList, List<Integer> needs) {
        int n = needs.size();
        int minPrice = currentPrice;
        for (List<Integer> special : specialList) {
            if (isValidSpecial(special, needs)) {
                List<Integer> newNeeds = useSpecial(special, needs);
                int newPrice = currentPrice - calculatePrice(price, special) + special.get(n);
                newPrice = tryUseSpecial(newPrice, price, specialList, newNeeds);
                minPrice = Math.min(newPrice, minPrice);
            }
        }


        return minPrice;
    }

    private int calculatePrice(List<Integer> price, List<Integer> counts) {
        if (cache.containsKey(counts)) {
            return cache.get(counts);
        }

        int totalPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            totalPrice += counts.get(i) * price.get(i);
        }

        cache.put(counts, totalPrice);
        return totalPrice;
    }

    private boolean isValidSpecial(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> useSpecial(List<Integer> special, List<Integer> needs) {
        List<Integer> newNeeds = new ArrayList<>(needs);
        for (int i = 0; i < newNeeds.size(); i++) {
            newNeeds.set(i, newNeeds.get(i) - special.get(i));
        }
        return newNeeds;
    }
}
