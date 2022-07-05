package com.lmmmowi.leetcode.p470;

import java.util.Random;

/**
 * @Author: mowi
 * @Date: 2022/7/5
 * @Description: 470. 用 Rand7() 实现 Rand10()[https://leetcode.cn/problems/implement-rand10-using-rand7/]
 */
public class Solution extends SolBase {

    public int rand10() {
        int a = rand7();
        int b = rand7();
        int sum = a + b;

        if (b <= 4) {
            return a;
        } else if (sum == 6 || sum == 8) {
            return 8;
        } else if (sum == 7 || sum == 13) {
            return 9;
        } else if (sum == 12 || sum == 14) {
            return 10;
        } else {
            return rand10();
        }
    }
}

class SolBase {

    private static final Random RANDOM = new Random();

    public int rand7() {
        return RANDOM.nextInt(7) + 1;
    }
}