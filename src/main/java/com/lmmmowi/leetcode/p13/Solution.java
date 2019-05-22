package com.lmmmowi.leetcode.p13;

/**
 * @Author: mowi
 * @Date: 2019-05-22
 * @Description: 13.罗马数字转整数[https://leetcode-cn.com/problems/roman-to-integer/]
 */
public class Solution {

    public int romanToInt(String s) {
        int lv = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = transfer(c);

            if (lv < v) {
                sum -= lv * 2;
            }
            sum += v;
            lv = v;
        }

        return sum;
    }

    private int transfer(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
