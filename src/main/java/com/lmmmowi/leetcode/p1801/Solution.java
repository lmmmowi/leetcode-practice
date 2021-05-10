package com.lmmmowi.leetcode.p1801;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: mowi
 * @Date: 2021/5/10
 * @Description: 1801. 积压订单中的订单总数[https://leetcode-cn.com/problems/number-of-orders-in-the-backlog/]
 */
public class Solution {

    private static final int BUY_ORDER = 0;
    private static final int MOD_NUM = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        Comparator<Order> orderComparator = Comparator.comparing(o -> o.price);
        PriorityQueue<Order> buyOrder = new PriorityQueue<>(orderComparator.reversed());
        PriorityQueue<Order> sellOrder = new PriorityQueue<>(orderComparator);

        for (int[] orderInfo : orders) {
            int price = orderInfo[0], amount = orderInfo[1], orderType = orderInfo[2];

            boolean isBuyOrder = orderType == BUY_ORDER;
            PriorityQueue<Order> consumer = isBuyOrder ? sellOrder : buyOrder;
            PriorityQueue<Order> producer = isBuyOrder ? buyOrder : sellOrder;

            while (amount > 0) {
                Order consumerOrder = consumer.peek();
                int tradeAmount = consumerOrder == null ? 0 : trade(price, amount, consumerOrder);
                if (tradeAmount == 0) {
                    break;
                }

                amount -= tradeAmount;
                consumerOrder.amount -= tradeAmount;
                if (consumerOrder.amount == 0) {
                    consumer.poll();
                }
            }

            if (amount > 0) {
                Order order = new Order(price, amount, orderType);
                producer.add(order);
            }
        }

        int result = 0;
        for (Order order : buyOrder) {
            result = (result + order.amount) % MOD_NUM;
        }
        for (Order order : sellOrder) {
            result = (result + order.amount) % MOD_NUM;
        }
        return result;
    }

    private int trade(int price, int amount, Order order) {
        boolean priceOk = order.orderType == BUY_ORDER
                ? price <= order.price
                : price >= order.price;
        return priceOk ? Math.min(amount, order.amount) : 0;
    }

    private class Order {
        private int price;
        private int amount;
        private int orderType;

        Order(int price, int amount, int orderType) {
            this.price = price;
            this.amount = amount;
            this.orderType = orderType;
        }
    }
}
