package com.lmmmowi.leetcode.p8;

/**
 * @Author: mowi
 * @Date: 2019-05-25
 * @Description: 8.字符串转换整数 (atoi)[https://leetcode-cn.com/problems/string-to-integer-atoi/]
 */
public class Solution {

    public int myAtoi(String str) {
        int res = 0;
        boolean begin = false;
        boolean positive = true;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!begin) {
                // 跳过开头空格
                if (c == ' ') {
                    continue;
                } else if (c == '+' || c == '-') {
                    positive = c == '+';
                    begin = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    begin = true;
                }
                // 以非法字符开头
                else {
                    break;
                }
            }

            if (c >= '0' && c <= '9') {
                int tmp = res;
                res = res * 10 + (c - '0');

                // 处理越界
                if (res / 10 != tmp) {
                    // 如果结果是正数直接判定越界
                    if (positive) {
                        return Integer.MAX_VALUE;
                    }
                    // 如果结果是负数且res大于Integer.MIN_VALUE，则判定越界
                    else if (res > Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }

        // 负数
        if (!positive) {
            res = -res;
        }

        return res;
    }
}
