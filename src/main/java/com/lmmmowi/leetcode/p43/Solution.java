package com.lmmmowi.leetcode.p43;

/**
 * @Author: mowi
 * @Date: 2019-06-10
 * @Description: 43.字符串相乘[https://leetcode-cn.com/problems/multiply-strings/]
 */
public class Solution {

    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int v1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int v2 = num2.charAt(j) - '0';
                int index = (num1.length() - i - 1) + (num2.length() - j - 1);
                this.setValue(sb, index, v1 * v2);
            }
        }
        String result = sb.reverse().toString();
        return result.startsWith("0") ? "0" : result;
    }

    private void setValue(StringBuilder sb, int index, int value) {
        if (sb.length() <= index) {
            sb.append('0');
        }

        int tmp = sb.charAt(index) - '0' + value;
        sb.setCharAt(index, (char) (tmp % 10 + '0'));
        if (tmp >= 10) {
            this.setValue(sb, index + 1, tmp / 10);
        }
    }
}
