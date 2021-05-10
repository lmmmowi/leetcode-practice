package com.lmmmowi.leetcode.p679;

/**
 * @Author: mowi
 * @Date: 2021/5/10
 * @Description: 679. 24 点游戏[https://leetcode-cn.com/problems/24-game/]
 */
public class Solution {

    private static final int TARGET = 24;
    private static final double TOLERANCE = 0.00001;

    public boolean judgePoint24(int[] cards) {
        double[] doubleCards = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            doubleCards[i] = cards[i];
        }
        return judge(doubleCards, 4);
    }

    private boolean judge(double[] cards, int cardNum) {
        int size = cards.length;
        for (int i = 0; i < size; i++) {
            if (cards[i] == 0 || cardNum == 1) {
                if (Math.abs(TARGET - cards[i]) < TOLERANCE) {
                    return true;
                }
                continue;
            }

            for (int j = i + 1; j < size; j++) {
                if (cards[j] == 0) {
                    continue;
                }

                double card1 = cards[i];
                double card2 = cards[j];
                double max = Math.max(cards[i], cards[j]);
                double min = Math.min(cards[i], cards[j]);
                cards[i] = 0;

                // 加
                cards[j] = max + min;
                if (judge(cards, cardNum - 1)) return true;

                // 减
                cards[j] = max - min;
                if (judge(cards, cardNum - 1)) return true;

                // 乘
                cards[j] = max * min;
                if (judge(cards, cardNum - 1)) return true;

                // 除
                cards[j] = max / min;
                if (judge(cards, cardNum - 1)) return true;
                cards[j] = min / max;
                if (judge(cards, cardNum - 1)) return true;

                // 恢复原来的数字
                cards[i] = card1;
                cards[j] = card2;
            }
        }
        return false;
    }
}
