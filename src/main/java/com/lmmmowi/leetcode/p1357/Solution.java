package com.lmmmowi.leetcode.p1357;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lmmmowi
 * @Date: 2020/10/22
 * @Description: 1357.每隔 n 个顾客打折[https://leetcode-cn.com/problems/apply-discount-every-n-orders/]
 */
public class Solution {

    class Cashier {

        private int discountInterval;
        private int discount;
        private Map<Integer, Integer> priceLookup = new HashMap<>();
        private int orderCount;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.discountInterval = n;
            this.discount = discount;

            for (int i = 0; i < products.length; i++) {
                priceLookup.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            orderCount++;
            double totalPrice = this.getOrderPrice(product, amount);
            return this.applyDiscount(totalPrice);
        }

        private double getOrderPrice(int[] product, int[] amount) {
            double sum = 0;
            for (int i = 0; i < product.length; i++) {
                sum += priceLookup.get(product[i]) * amount[i];
            }
            return sum;
        }

        private double applyDiscount(double price) {
            return orderCount % discountInterval == 0
                    ? price * (100 - discount) / 100
                    : price;
        }
    }
}
