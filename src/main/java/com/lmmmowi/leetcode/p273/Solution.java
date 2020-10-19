package com.lmmmowi.leetcode.p273;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2020/9/14
 * @Description: 273.整数转换英文表示[https://leetcode-cn.com/problems/integer-to-english-words/]
 */
public class Solution {

    private static final String[] SUFFIX_ARR = new String[]{"", "Thousand", "Million", "Billion"};
    private static final String[] NUM_ARR = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] NUM_ARR_1x = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] NUM_ARR_x0 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return NUM_ARR[0];
        }

        StringBuilder sb = new StringBuilder();

        int suffixIndex = 0;
        while (num > 0) {
            int subNum = num % 1000;
            if (subNum > 0) {
                String s = subNumberToWords(subNum);
                if (sb.length() > 0) {
                    sb.insert(0, " ");
                }
                if (suffixIndex > 0) {
                    sb.insert(0, " " + SUFFIX_ARR[suffixIndex]);
                }
                sb.insert(0, s);
            }

            num /= 1000;
            suffixIndex++;
        }

        return sb.toString();
    }

    private String subNumberToWords(int num) {
        int a = num / 100;
        int b = num % 100 / 10;
        int c = num % 10;

        List<String> parts = new ArrayList<>();

        if (a > 0) {
            parts.add(NUM_ARR[a]);
            parts.add("Hundred");
        }

        if (b == 1) {
            parts.add(NUM_ARR_1x[c]);
        } else {
            if (b > 1) {
                parts.add(NUM_ARR_x0[b]);
            }
            if (c > 0) {
                parts.add(NUM_ARR[c]);
            }
        }

        return String.join(" ", parts);
    }
}