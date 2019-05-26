package com.lmmmowi.leetcode.p12;

/**
 * @Author: mowi
 * @Date: 2019/5/26
 * @Description: 12.整数转罗马数字[https://leetcode-cn.com/problems/integer-to-roman/]
 */
public class Solution {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int k = 1;
        while (num > 0) {
            int i = num % 10;
            sb.insert(0, itor(i, k));
            num /= 10;
            k++;
        }
        return sb.toString();
    }

    private String itor(int m, int k) {
        final char[] chars = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M', 0, 0};

        char one = chars[(k - 1) * 2];
        char five = chars[(k - 1) * 2 + 1];
        char ten = chars[(k - 1) * 2 + 2];

        StringBuilder sb = new StringBuilder();
        if (m == 9) {
            sb.append(one).append(ten);
        } else if (m == 4) {
            sb.append(one).append(five);
        } else {
            if (m >= 5) {
                sb.append(five);
                m -= 5;
            }
            for (int i = 0; i < m; i++) {
                sb.append(one);
            }
        }
        return sb.toString();
    }
}
